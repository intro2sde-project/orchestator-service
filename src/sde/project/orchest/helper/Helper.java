package sde.project.orchest.helper;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import sde.project.orchest.model.Quote;
import sde.project.soap.BeerInterf;
import sde.project.soap.RecomService;
import sde.project.soap.User;

public class Helper {
	

	BeerInterf soapService;
	WebTarget restService;
	List<Quote> quotes;
	
	
	public List <Quote> GenQuotes() {
		
		Quote quote0 = new Quote();
		Quote quote1 = new Quote();
		Quote quote2 = new Quote();
		Quote quote3 = new Quote();
		Quote quote4 = new Quote();
		Quote quote5 = new Quote();
		Quote quote6 = new Quote();
		Quote quote7 = new Quote();
		Quote quote8 = new Quote();
		Quote quote9 = new Quote();
		Quote quote10 = new Quote();
		Quote quote11 = new Quote();
		Quote quote12 = new Quote();
		Quote quote13 = new Quote();
		Quote quote14 = new Quote();
		Quote quote15 = new Quote();
		Quote quote16 = new Quote();
		Quote quote17 = new Quote();
		
		quotes = new ArrayList<Quote>();
		
		quote0.setQuote("\"Always do sober what you said you'd do drunk. That will teach you to keep your mouth shut.\" \n");
		quote0.setAuthor("Ernest Hemingway");
		quotes.add(quote0);
		
		quote1.setQuote("\"I drink to make other people more interesting.\" \n");
		quote1.setAuthor("Ernest Hemingway");
		quotes.add(quote1);
		
		quote2.setQuote("\"Ho! Ho! Ho! To the bottle I go\n" + 
				"To heal my heart and drown my woe\n" + 
				"Rain may fall, and wind may blow\n" + 
				"And many miles be still to go\n" + 
				"But under a tall tree will I lie\n" + 
				"And let the clouds go sailing by.\" \n");
		quote2.setAuthor("J.R.R. Tolkien");
		quotes.add(quote2);
		
		quote3.setQuote("\"Here's to alcohol, the rose colored glasses of life.\" \n");
		quote3.setAuthor("F. Scott Fitzgerald");
		quotes.add(quote3);
		
		quote4.setQuote("\"Next to music, beer was best.\" \n");
		quote4.setAuthor("Ernest Hemingway");
		quotes.add(quote4);
		
		quote5.setQuote("\"Carson McCullers\" \n");
		quote5.setAuthor("Ernest Hemingway");
		quotes.add(quote5);
		
		quote6.setQuote("\"In wine there is wisdom, in beer there is Freedom, in water there is bacteria.\" \n");
		quote6.setAuthor("Benjamin Franklin");
		quotes.add(quote6);
		
		quote7.setQuote("\"A lady came up to me one day and said 'Sir! You are drunk', to which I replied 'I am drunk today madam, and tomorrow I shall be sober but you will still be ugly.\" \n");
		quote7.setAuthor("Anonymous");
		quotes.add(quote7);
		
		quote8.setQuote("\"First you take a drink, then the drink takes a drink, then the drink takes you.\" \n");
		quote8.setAuthor("F. Scott Fitzgerald");
		quotes.add(quote8);
		
		quote9.setQuote("\"I like to have a martini,\n" + 
				"Two at the very most.\n" + 
				"After three I'm under the table,\n" + 
				"after four I'm under my host.\" \n");
		quote9.setAuthor("Dorothy Parker");
		quotes.add(quote9);
		
		quote10.setQuote("\"I cook with wine, sometimes I even add it to the food.\" \n");
		quote10.setAuthor("W.C. Fields");
		quotes.add(quote10);
		
		quote11.setQuote("\"Alcohol may be man's worst enemy, but the bible says love your enemy.\" \n");
		quote11.setAuthor("Frank Sinatra");
		quotes.add(quote11);
		
		quote12.setQuote("\"An intelligent man is sometimes forced to be drunk to spend time with his fools.\" \n");
		quote12.setAuthor("Ernest Hemingway");
		quotes.add(quote12);
		
		quote13.setQuote("\"Good people drink good beer.\" \n");
		quote13.setAuthor("Ernest Hemingway");
		quotes.add(quote13);
		
		quote14.setQuote("\"Life is too short drink bad wine.\" \n");
		quote14.setAuthor("J.W. von Goethe");
		quotes.add(quote14);
		
		quote15.setQuote("\"Alcohol, taken in sufficient quantities, may produce all the effects of drunkenness.\" \n");
		quote15.setAuthor("Oscar Wilde");
		quotes.add(quote15);
		
		quote16.setQuote("\"Wine is the most healthful and most hygienic of beverages.\" \n");
		quote16.setAuthor("Louis Pasteur");
		quotes.add(quote16);
		
		quote17.setQuote("\"Too much of anything is bad, but too much Champagne is just right.\" \n");
		quote17.setAuthor("F. Scott Fitzgerald");
		quotes.add(quote17);
		
				
		return quotes;
	}

	    
	public Helper() {
		super();
	}
	
	    
	    /*
	     * The base URI of WineRecom API.
	     */
	    private static URI getBaseURI() {
			return UriBuilder.fromUri(
					"https://wine-recomm-rest.herokuapp.com/sde/wine").build();
		}
   
	/*
     * Get WineRecom service, if null create one.
     */
    public WebTarget getRestService() {
    	if(restService == null) {
        	ClientConfig clientConfig = new ClientConfig();
    		Client client = ClientBuilder.newClient(clientConfig);
    		restService = client.target(getBaseURI());
    	}
    	return restService;
    }
    
    
    /*
     * Get Beer	Recom service, if null create one.
     */
    public BeerInterf getSoapService() {
    	if(soapService == null) {
    		//System.out.println("prima");
    		RecomService beerService = new RecomService();       
    		soapService = beerService.getBeerImplPort();
    		//System.out.println("dopo");
    	}
    	return soapService;
    }

    
    public User getUserByUsername(String username) {
        System.out.println("Reading user from DB with id: " + username);

        // this will work within a Java EE container, where not DAO will be needed
        //User user = entityManager.find(User.class, userId); 

        User user = getSoapService().readUser(username);
        System.out.println("User: "+ user.toString());
        return user;
    }
    
    public boolean isLogged(String username, String password) {
    	
		this.getSoapService();
		System.out.println("Verifying user...");
		
		List<User> userList = new ArrayList<User> ();
		userList = soapService.readUserList();
		
		Iterator it = userList.iterator();
		while (it.hasNext()) {
			  User user = (User) it.next();
			  if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				  System.out.println("Logging in...");
				  return true; 
			  }		 
						
		} 
		System.out.println("User not registered...");			
		return false;
    }


	public List<Quote> getQuotes() {
		return quotes;
	}


	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
    
    

}
