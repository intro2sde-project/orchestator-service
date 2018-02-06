package sde.project.orchest.resource;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sde.project.orchest.helper.Helper;
import sde.project.orchest.model.Wine;
import sde.project.orchest.model.WineReview;
import sde.project.soap.User;

@Stateless // only used if the the application is deployed in a Java EE container
@LocalBean // only used if the the application is deployed in a Java EE container
public class WineResource {
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @Context
    Response response;
    @Context
	WebTarget service;
    @Context
    String username;
    @Context
    Helper helper;
    
    
    // will work only inside a Java EE application
    @PersistenceUnit(unitName="introsde-jpa")
    EntityManager entityManager;

    // will work only inside a Java EE application
    @PersistenceContext(unitName = "introsde-jpa",type=PersistenceContextType.TRANSACTION)
    private EntityManagerFactory entityManagerFactory;
    
    
    public WineResource(UriInfo uriInfo, Request request, String username) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.username = username;
    }
    
    
    /*
     * The base URI of snooth API.
     */
    private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"https://wine-recomm-rest.herokuapp.com/sde/wine").build();
	}
    
    
    /*
     * Get Snooth service, if null create one.
     */
    private WebTarget getService() {
    	if(service == null) {
        	ClientConfig clientConfig = new ClientConfig();
    		Client client = ClientBuilder.newClient(clientConfig);
    		service = client.target(getBaseURI());
    	}
    	return service;
    }

    
    /* REST METHODS*/
    
    
    @GET
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public String getAvailableMethos() {
        System.out.println("Getting list of methods...");
        return "{SURPRISE}";
    }
    
    
    /*
     *  Perform a research 
     */   
    @GET
    @Path("/search")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public List<Wine> getWineList(
    		@DefaultValue("wine") @QueryParam("search") String search, 
    		@DefaultValue("") @QueryParam("type") String type, 
    		@DefaultValue("") @QueryParam("color") String color, 
    		@DefaultValue("") @QueryParam("country") String country, 
    		@DefaultValue("10000.0") @QueryParam("maxprice") String maxprice, 
    		@DefaultValue("0.0") @QueryParam("minprice") String minprice, 
    		@DefaultValue("0.0") @QueryParam("minrank") String minrank, 
    		@DefaultValue("5.0") @QueryParam("maxrank") String maxrank) throws JsonParseException, JsonMappingException, IOException  {
    	
    	
    	List<Wine> list = new ArrayList<Wine>();
    	
    	response = getService()
        			.path("search")
        			.queryParam("search", search)
        			.queryParam("type", type)
        			.queryParam("country", country)
        			.queryParam("color", color)
        			.queryParam("minprice", minprice)
        			.queryParam("minprice", minprice)
        			.queryParam("minrank", minrank)
        			.queryParam("maxrank", maxrank)
        			.request()
        			.accept(MediaType.APPLICATION_JSON)
        			.get();
    	
    	String responseBody = response.readEntity(String.class);
		System.out.println(responseBody);
		JSONArray Response = new JSONArray (responseBody);
		
		ObjectMapper mapper = new ObjectMapper();
		for(Object jO : Response) {
			list.add( mapper.readValue( ((JSONObject) jO).toString() , Wine.class ));
		}
		return list;
    
    
    }
    
    /*
     * Rate a particoular wine
     */
    @GET
    @Path("/rate")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    @Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public WineReview rateWine( 
			@QueryParam("password") String password,
    		@QueryParam("rating") double rating,
    		@QueryParam("code") String code,
    		@QueryParam("review") String review,
    		@QueryParam("iswish") int isWish
    		) throws JsonProcessingException {
    	
    	helper = new Helper();
    	User user = helper.getUserByUsername(username);
    	//User user = new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	if(!helper.isLogged(user.getUsername(), user.getPassword())) {
    		return null;
    	}
    	
    	if((user.getUsername() != null || user.getEmail() != null) &&
    	    user.getPassword() != null) {

    		String id = user.getUsername() == null ? user.getEmail() : user.getUsername();
    		ObjectMapper mapper = new ObjectMapper();
    		response = getService()
        			.path("rate")
        			.queryParam("review", review)
        			.queryParam("rating", rating)
        			.queryParam("code", code)
        			.queryParam("isWish", isWish)
        			.request()
        			.accept(MediaType.APPLICATION_JSON)
        			.header("Content-type","application/json")
        			.put(Entity.json(mapper.writeValueAsString(user)));
    		
    		String responseBody = response.readEntity(String.class);
			System.out.println(responseBody);
    		JSONObject jResponse = new JSONObject(responseBody);
    		
			WineReview wr = new WineReview();
			try {
				wr = mapper.readValue( jResponse.toString() , WineReview.class );
			}catch(Exception e) {
				System.out.println("Something's wrong with:  create WineReview ->" + e);
			}
    		return wr;
    	}

    	return null;
    }
    
    
    /*
     * Get wine's details
     */
    @GET
    @Path("/details")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public Wine getWineDetails(
    		@QueryParam("code") String code, 
    		@QueryParam("food") int food) {
    	
    	

		System.out.println("bb".toString());
    	response = getService()
    			.path("details")
    			.queryParam("username", username)
    			.queryParam("code", code)
    			.queryParam("food", food)
    			.request()
    			.accept(MediaType.APPLICATION_JSON)
    			.get();
    	
    	String responseBody = response.readEntity(String.class);
		System.out.println(responseBody);
		JSONObject jResponse = new JSONObject(responseBody);
		
		ObjectMapper mapper = new ObjectMapper();
		Wine wine = new Wine();
		try {
			wine = mapper.readValue( jResponse.toString() , Wine.class );
		}catch(Exception e) {
			System.out.println("Something's wrong with:  get Wine's details ->" + e);
		}
		
		/*
		 * String idrec = WineRecom.addWine(wine);
		 *WineRecom.addView(name, Long.parseLong(idrec));
		 */
		return wine;
    }
    
    
    /*
     * Get my Wines
     */
    @GET
    @Path("/mywine")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    @Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public List<Wine> getMyWineList( 
    		@QueryParam("password") String password, 
    		@DefaultValue("0") @QueryParam("showrating") int showrating) throws IOException  {
    	
    	helper = new Helper();
    	User user = helper.getUserByUsername(username);
    	//User user = new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	if(!helper.isLogged(user.getUsername(), user.getPassword())) {
    		return null;
    	}
    	
    	List<Wine> wines = new ArrayList<>();
    	
    	if((user.getUsername() != null || user.getEmail() != null) &&
        	    user.getPassword() != null) {
    		
    		String id = user.getUsername() == null ? user.getEmail() : user.getUsername(); 		
    		
    		ObjectMapper mapper = new ObjectMapper();
    		
	    	response = getService()
	    			.path("mywine")
	    			.queryParam("showrating", showrating)
	    			.request()
	    			.accept(MediaType.APPLICATION_JSON)
        			.header("Content-type","application/json")
        			.post(Entity.json(mapper.writeValueAsString(user)));
			
			String responseBody = response.readEntity(String.class);
			System.out.println(responseBody);
			JSONArray Response = new JSONArray (responseBody);
			
			for(Object jO : Response) {
				wines.add( mapper.readValue( ((JSONObject) jO).toString() , Wine.class ));
			}
			return wines;
    	}
    	
    	
    	return null;
    }
    
    
    /*
     * Get wines' recommendation
     */
    @GET
    @Path("/recom")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    @Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public List<Wine> getWineRecomList(
    		@QueryParam("password") String password) throws IOException  {
    	
    	List<Wine> wines = new ArrayList<>();
    	
    	helper = new Helper();
    	User user = helper.getUserByUsername(username);
    	//User user = new User();
    	if(!helper.isLogged(username, password)) {
    		wines.add(new Wine());
    		return wines;
    	}
    	
		ObjectMapper mapper = new ObjectMapper();

    	/*the API doesn't support a blank color*/
		response = getService()
    			.path("recom")
    			.request()
    			.accept(MediaType.APPLICATION_JSON)
    			.header("Content-type","application/json")
    			.post(Entity.json(mapper.writeValueAsString(user)));
		
		String responseBody = response.readEntity(String.class);
		System.out.println(responseBody);
		JSONArray Response = new JSONArray (responseBody);
		
		for(Object jO : Response) {
				wines.add( mapper.readValue( ((JSONObject) jO).toString() , Wine.class ));
			}
		
		return wines;
    }
    
    public String getUsernameFromPath(String url) {
    	String ret;
    	
    	String splitty [] = url.split("/");
    	
    	return splitty[5];
    }
}