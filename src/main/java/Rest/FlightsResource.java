/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Airline;
import Entity.Flight;
import Exceptions.FlightException;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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

    ArrayList<Flight> flightList = new ArrayList<Flight>() {
        {
            add(new Flight("5342-5374581236347", "KAF6666", "2016-11-22T00:00:00.000Z", 6, 67, 240, "CPH", "SXF"));
            add(new Flight("4443-8765989054363", "KAF3466", "2016-12-03T00:00:00.000Z", 9, 239, 120, "CPH", "STN"));
            add(new Flight("2323-8675048485030", "KAF6622", "2016-03-12T00:00:00.000Z", 4, 190, 60, "STN", "SXF"));
            add(new Flight("8765-0101909245668", "KAF5789", "2017-01-05T00:00:00.000Z", 12, 300, 264, "STN", "CPH"));
            add(new Flight("6464-0192837465951", "KAF1113", "2017-02-01T00:00:00.000Z", 14, 200, 210, "SXF", "CPH"));
        }
    };
    
    private static final HashMap<String, Boolean> VALIDPLACES = new HashMap<>();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlightsResource
     */
    public FlightsResource() {
        VALIDPLACES.put("cph", true);
        VALIDPLACES.put("sxf", true);
        VALIDPLACES.put("stn", true);
        VALIDPLACES.put("cdg", true);
        VALIDPLACES.put("bcn", true);
    }

    /**
     * Retrieves representation of an instance of Rest.FlightsResource
     *
     * @param from
     * @param date
     * @param tickets
     * @return an instance of java.lang.String
     * @throws Exceptions.FlightException
     */
    @GET // Fetches available flights from a specific location, given a date
    @Path("/{from}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromDate(@PathParam("from") String from, @PathParam("date") String date, @PathParam("tickets") int tickets) throws FlightException {
       
        if(VALIDPLACES.get(from.toLowerCase()) == null) throw new FlightException(400, 3, "The from place is invalid");
        if(tickets == 0) throw new FlightException(400, 3, "No tickets");
        
        // Let's assume we wil not run out of tickets
        
                
        Airline airline = new Airline("Kaffemænd Tours");
        for (Flight x : flightList) {
            if (x.getDate().equals(date) && x.getOrigin().equals(from)) {
                
                airline.addFlight(x);
            }
        }
        //System.out.println("Length: " + airline.getFlights().size());
        String res = gson.toJson(airline);

        if (airline.getFlights().isEmpty()) {
            throw new FlightException(400, 1, "There were no flights");
        }

        return res;
    }

    /**
     * PUT method for updating or creating an instance of FlightsResource
     *
     * @param from
     * @param to
     * @param date
     * @param tickets
     * @return 
     * @throws Exceptions.FlightException 
     */
    @GET // Fetches available flights from and to a specific location, given a date 
    @Path("/{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromToDateTick(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("tickets") int tickets) throws FlightException {
        if(VALIDPLACES.get(to.toLowerCase()) == null) throw new FlightException(400, 3, "The to place is invalid");
        if(VALIDPLACES.get(from.toLowerCase()) == null) throw new FlightException(400, 3, "The from place is invalid");
        if(tickets == 0) throw new FlightException(400, 3, "No tickets");
        
        Airline airline = new Airline("Kaffemænd Tours");
        for (Flight x : flightList) {
            if (x.getDate().equals(date) && x.getOrigin().equals(from) && x.getDestination().equals(to)) {
                airline.addFlight(x);
            }
        }
        String res = gson.toJson(airline);
        return res;
    }
}
