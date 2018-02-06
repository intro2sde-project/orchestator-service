package sde.project.orchest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("sde")


public class MyApplicationConfig extends ResourceConfig {
	    public MyApplicationConfig () {
	        packages("sde.project.orchest");
	    }
}
