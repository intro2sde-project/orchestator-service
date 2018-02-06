package sde.project.orchest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import sde.project.soap.BeerInterf;
import sde.project.soap.RecomService;
public class App {
	
	 private static final URI BASE_URI = URI.create("http://localhost:5900/project/");	
	    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
	    {
	    	
	  	 
	 	RecomService beerService = new RecomService();
	        
	 	BeerInterf beers = beerService.getBeerImplPort();
	    	
	 	
	 	System.out.println(beers.readUserList());
	    	
	    	System.out.println("Starting orchest standalone HTTP server...");
	        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
	        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");
	    }

	    public static ResourceConfig createApp() {
	    	System.out.println("Starting orchest REST services...");
	        return new MyApplicationConfig();
	    }

}
