/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lasse
 */
@Path("flights")
public class FlightsResource {
    
    private static final Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlightsResource
     */
    public FlightsResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.FlightsResource
     * @param from
     * @param date
     * @param tickets
     * @return an instance of java.lang.String
     */
    @GET // Fetches available flights from a specific location, given a date
    @Path("/{from}/{date}/{tickets}") 
    @Produces(MediaType.APPLICATION_JSON)
    public String fromDate(@PathParam("from") String from, @PathParam("date") String date, @PathParam("tickets") int tickets) {
        JsonObject jo = new JsonObject();
        // TODO: Do real data
        
        jo.addProperty("From", from);
        jo.addProperty("Date", date);
        jo.addProperty("Tickets", tickets);
        
        return jo.toString();
    }

    @GET // Fetches available flights from and to a specific location, given a date 
    @Path("/{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromToDateTick(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("tickets") int tickets) {
        JsonObject jo = new JsonObject();
        
        jo.addProperty("From", from);
        jo.addProperty("To", to);
        jo.addProperty("Date", date);
        jo.addProperty("Tickets", tickets);
        
        return jo.toString();
    }
}
