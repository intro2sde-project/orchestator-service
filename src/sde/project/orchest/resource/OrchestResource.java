package sde.project.orchest.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.Holder;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import sde.project.soap.Beer;
import sde.project.soap.BeerInterf;
import sde.project.soap.RecomService;
import sde.project.soap.User;
import sde.project.orchest.helper.Helper;
import sde.project.orchest.model.Quote;

@Stateless // will work only inside a Java EE application
@LocalBean // will work only inside a Java EE application
@Path("/orch")
public class OrchestResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @Context
    BeerInterf soapService;
    @Context
	WebTarget restService;
    @Context
	WebTarget quoteService;
    Response resp;
    String response="";
    List<Quote> quoteList;
    
    Helper helper;
    
    
    /*
     * The base URI of WineRecom API.
     */
    private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://quotes.rest/").build();
	}

/*
 * Get WineRecom service, if null create one.
 */
public WebTarget getQuoteService() {
	if(quoteService == null) {
    	ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		quoteService = client.target(getBaseURI());
	}
	return quoteService;
}

    // Return the list of people to the user in the browser
    @GET
    @Path("users")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public List<User> getPersonsBrowser() {
    	helper = new Helper();
    	soapService = helper.getSoapService();
        System.out.println("Getting list of people...");
        System.out.println(soapService.readUserList() + " wat");
        List<User> users = soapService.readUserList();
        return users;
    }

    // retuns the number of people
    // to get the total number of records
    @GET
    @Path("login")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML })
    public User logUser( @QueryParam("username") String username, 
            			 @QueryParam("password") String password) {
    		helper = new Helper();
    		soapService = helper.getSoapService();
    		System.out.println("Verifying user...");
    		
    		List<User> userList = new ArrayList<User> ();
    		userList = soapService.readUserList();
    		
    		Iterator<User> it = userList.iterator();
    		while (it.hasNext()) {
 
    			  User user = (User) it.next();

    			  if (user.getUsername().equals(username) ) {
    				  if(user.getPassword().equals(password)) {
    				  System.out.println("Logging in...");
    				  return user; 
    				  }
    				  else {
    					  System.out.println("wrong password");
    				  }
    			  }	
    		} 
    		System.out.println("User not registered...");			
    		return null;
    	
    }
    
    @GET
    @Path("register")
    @Produces({MediaType.TEXT_PLAIN,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public boolean registerUser( @QueryParam("username") String username, 
            					 @QueryParam("password") String password,
            					 @QueryParam("email") String email) {
    	helper = new Helper();
    		User user = new User();
    		soapService = helper.getSoapService();
    		
		List<User> userList = new ArrayList<User> ();
		userList = soapService.readUserList();
		System.out.println(userList + " reg");
		Iterator<User> it = userList.iterator();
		while (it.hasNext()) {
			  User val = (User) it.next();
			  if (val.getUsername().equals(username)) {
				
				  System.out.println("User already registerd.... change username");
				  return false;  	
			    
			  }else {
					
				  	user.setUsername(username);
				  	user.setPassword(password);
				  	user.setEmail(email);
				  	Holder<User> userHold = new Holder<User>(user);			  	
						
					soapService.createUser(userHold);
					System.out.println("User registered...");
				  return true;
			  }
   
		}
		System.out.println("something went wrong");
		return false;
    }
    
    // Return the list of people to the user in the browser
    @GET
    @Path("quotesStud")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public JSONObject getStudentQuotes() throws ParseException {
    	 helper = new Helper();
    	String quote = "";
    		
    	quoteService = getQuoteService();
    	System.out.println("hey");	
	    resp = quoteService.path("qod.json").queryParam("category", "students").request().accept(MediaType.APPLICATION_JSON).get();
	    System.out.println("=> HTTP Status: " + resp.getStatus() + " " + resp.getStatusInfo());
	    response = resp.readEntity(String.class);
	    System.out.println(response.toString());
	    
	  
	    JSONObject obj = new JSONObject(response);
	    JSONObject content = obj.getJSONObject("contents");
	    JSONArray quotes = content.getJSONArray("quotes");
	    
	    JSONObject first = quotes.getJSONObject(0);
	    //JSONObject third = quotes.getJSONObject(2);
	    
	    String author = first.getString("author");
	    quote = first.getString("quote");
		JSONParser parser = new JSONParser();
	    
	    return (JSONObject) parser.parse("{\"quote\":\"" +quote + "\",\"author\":\"" + author+ "\"}");
    }
	    
    // Return the list of people to the user in the browser
    @GET
    @Path("quotesDrink")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public org.json.simple.JSONObject getDrinkQuotes() throws ParseException {	
    		helper = new Helper();
    		quoteList = helper.GenQuotes();
    		String quote = "";
    		
    		Random rand = new Random();

    		int  n = rand.nextInt(17) + 0;
    		
    		for(Quote q : quoteList) {
    			System.out.println(q.getQuote() + " " + q.getAuthor());
    		}
    		
    		System.out.println(n);
	    Quote quoteDrink = quoteList.get(n);
	    
	    quote = quoteDrink.getQuote() + "\n"
	    		+ "- " + quoteDrink.getAuthor() + "\n";

		JSONParser parser = new JSONParser();
		System.out.println("{\"quote\":" +quoteDrink.getQuote() + ",\"author\":\"" + quoteDrink.getAuthor()+ "\"}");
	    return (org.json.simple.JSONObject) parser.parse("{\"quote\":" +quoteDrink.getQuote() + ",\"author\":\"" + quoteDrink.getAuthor()+ "\"}");
      
    }
    
    @Path("beer/{username}")
    public BeerResource getBeersBrowser(@PathParam("username") String username  ) {
    		//UserlogUser(null, null);
        return new BeerResource(uriInfo, request, username);
    }
    
    @Path("wine/{username}")
    public WineResource getWinesBrowser(@PathParam("username") String username) {
        return new WineResource(uriInfo, request, username);
    }
    
   
}