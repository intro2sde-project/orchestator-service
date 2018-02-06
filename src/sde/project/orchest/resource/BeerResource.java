package sde.project.orchest.resource;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sde.project.orchest.helper.Helper;
import sde.project.orchest.model.WineReview;
import sde.project.soap.Beer;
import sde.project.soap.BeerInterf;
import sde.project.soap.User;


@Stateless // only used if the the application is deployed in a Java EE container
@LocalBean // only used if the the application is deployed in a Java EE container
public class BeerResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @Context
    String username;
    @Context
    BeerInterf soapService;
    Helper helper;
  
    public BeerResource(UriInfo uriInfo, Request request, String username) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.username = username;
    }
    
    
    @BeforeClass
    public static  void init(){ 
        System.setProperty( "com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize", "true");
    }

    @AfterClass
    public static void revert(){ 
        System.getProperties().remove("com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize");
    } 
    
    @GET
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public String getAvailableMethos() {
        System.out.println("Getting list of methods...");
        return "SURPRISE";
    }
    
    //rating beer
    @GET
    @Path("beer/rate/{beerId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    @Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public boolean get( @PathParam("beerId") long beerId,
            @QueryParam("rating") Integer rating) {
    	
    		helper = new Helper();
    		soapService = helper.getSoapService();
        User user = helper.getUserByUsername(username);
        Beer beer =  soapService.readBeer(beerId);
        
        soapService.rateUserBeer(user, beer, rating);
        
        System.out.println("beer rated");
        
        return true;
        
        
    }
    
    
    //add beer to user wishlist
    @GET
    @Path("/addwl/{beerId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public long addBeerToWishList( @PathParam("beerId") Long beerId) {
		
    	
    	helper = new Helper();
		soapService = helper.getSoapService();
		User user = helper.getUserByUsername(username);
        Beer beer =  soapService.readBeer(beerId);
        
        soapService.addBeerToUser(user, beer);
        
        System.out.println("beer added to wishlist...");
        
    	return beerId;
    	 	
    }
    
    //add beer to user wishlist
    @GET
    @Path("/removewl/{beerId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public long removeBeerFromWishList( @PathParam("beerId") Long beerId) {
		
    	
    		helper = new Helper();
		soapService = helper.getSoapService();
		User user = helper.getUserByUsername(username);
        Beer beer =  soapService.readBeer(beerId);
        
        soapService.removeBeerToUser(user, beer);
        
        System.out.println("beer removed to wishlist...");  
    		return beerId;
    	
    	
    }
    
    
    //Request#4
    @GET
    @Path("/recom")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})   
    public JSONArray getRecom(@QueryParam("rating") long count) throws JsonProcessingException, org.json.simple.parser.ParseException {
    		
    	helper = new Helper();
		soapService = helper.getSoapService();
		User user = helper.getUserByUsername(username);
    	List<Beer> beerList = soapService.getUserRecom(user, count);
    		
        System.out.println("getting recommendations...");   
        for(Beer beer : beerList) {
     		System.out.println("Beer " + beer.getIdBeer() + " in the list ==> "+ beer.getName());
         }

		JSONArray jRet = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser parser = new JSONParser();
		for(Beer b : beerList) {	
			JSONObject json = (JSONObject) parser.parse(mapper.writeValueAsString(b));
			jRet.add(json);
		}
    	return jRet;   
    }

    
    //Request#4
    @GET
    @Path("/wl")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public JSONArray getWishlist() throws JsonProcessingException, org.json.simple.parser.ParseException {
    		
    		helper = new Helper();
		soapService = helper.getSoapService();
		User user = helper.getUserByUsername(username);
		System.out.println("getting user wishlist..."); 
    		List<Beer> beerList =  soapService.readUserWL(user);
    		 for(Beer beer : beerList) {
    	     		System.out.println("Beer " + beer.getIdBeer() + " in the list ==> "+ beer.getName());
    	         }
    		
    		List<String> ids = new ArrayList<>();
			JSONArray jRet = new JSONArray();
			ObjectMapper mapper = new ObjectMapper();
			JSONParser parser = new JSONParser();
			for(Beer b : beerList) {	
				JSONObject json = (JSONObject) parser.parse(mapper.writeValueAsString(b));
				jRet.add(json);
			}
	    	return jRet;   
    }
    
    //Request#4
    @GET
    @Path("/search/{name}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Beer searchBeer( @PathParam("name") String name) {
    		
    	helper = new Helper();
		soapService = helper.getSoapService();
		User user = helper.getUserByUsername(username);
		//System.out.println("getting user wishlist..."); 
	
		List<Beer> beerList =  soapService.readBeerList();

		for(Beer beer : beerList) {
			System.out.println("loop");
			if(beer.getName().toString().equals(name)) {
				System.out.println("if");
				soapService.addUserView(user, beer);
				return beer;
			}
		}
		
    		return null;		
    	   
    }
    

  //Request#4
    @GET
    @Path("/searchall")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public JSONArray searchBeerAll( ) throws JsonProcessingException, org.json.simple.parser.ParseException {
    		
    	helper = new Helper();
		soapService = helper.getSoapService();
		System.out.println("getting user wishlist..."); 
		List<Beer> ret = soapService.readBeerList();
		List<String> ids = new ArrayList<>();
		JSONArray jRet = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		JSONParser parser = new JSONParser();
		for(Beer b : ret) {	
			JSONObject json = (JSONObject) parser.parse(mapper.writeValueAsString(b));
			jRet.add(json);
		}
    	return jRet;   
    }
    
    // get rate beer
    @GET
    @Path("getrate/{beerId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    @Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public double getRate( @PathParam("beerId") long beerId) {
    	
    		helper = new Helper();
    		soapService = helper.getSoapService();
        User user = helper.getUserByUsername(username);
        Beer beer =  soapService.readBeer(beerId);
        
        double rate = soapService.getBeerRatingUser(user, beer);
        
        System.out.println("beer rated");
        
        return rate;
        
        
    }
    

}