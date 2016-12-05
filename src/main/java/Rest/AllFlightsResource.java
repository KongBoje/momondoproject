/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions.FlightException;
import Extra.DownloadProxy;
import Extra.DownloadProxyScheduler;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * REST Web Service
 *
 * @author Lasse
 */
@Path("allflights")
public class AllFlightsResource {

    private static final Gson gson = new Gson();
    private static final DownloadProxy dp = new DownloadProxy();
    private static final String OURDATA = "http://localhost:8084/Momondoproject/";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlightsResource
     */
    public AllFlightsResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.AllFlightsResource
     *
     * @param from
     * @param date
     * @param tickets
     * @return an instance of java.lang.String
     */
    @GET // Fetches available flights from a specific location, given a date
    @Path("/{from}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromDate(@PathParam("from") String from, @PathParam("date") String date, @PathParam("tickets") int tickets) {
        ArrayList<EntityV2.Airline> airlines = new ArrayList<>();
        
        ArrayList<String> myHttp = new ArrayList<>();
        myHttp.add("http://airline-plaul.rhcloud.com/api/flightinfo/" + from + "/" + date + "/" + tickets);
        myHttp.add(OURDATA + "api/flights/" + from + "/" + date + "/" + tickets);


        DownloadProxyScheduler dps = new DownloadProxyScheduler();
        
        ArrayList<String> downloaded = dps.getResults(myHttp);
        
        for(int i = 0; i != myHttp.size(); i++) {
            if(downloaded.get(i) != null) {
                EntityV2.Airline tmpAirline = gson.fromJson(downloaded.get(i), EntityV2.Airline.class);
                tmpAirline.setSource(myHttp.get(i).substring(0, myHttp.get(i).indexOf("api/")));
                airlines.add(tmpAirline);
            }
        }
        
        return gson.toJson(airlines);
    }

    @GET // Fetches available flights from and to a specific location, given a date 
    @Path("/{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromToDateTick(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("tickets") int tickets) {
        ArrayList<EntityV2.Airline> airlines = new ArrayList<>();
        String larsAirline;
        String kaffeAirline;

        /*try {
            larsAirline = dp.GetHttpRequest("http://airline-plaul.rhcloud.com/api/flightinfo/" + from + "/" + to + "/" + date + "/" + tickets);
            EntityV2.Airline a1 = gson.fromJson(larsAirline, EntityV2.Airline.class);
            airlines.add(a1);
        } catch (FlightException ex) {
            System.out.println(ex.getLocalizedMessage());
        }*/

        try {
            kaffeAirline = dp.GetHttpRequest(OURDATA + "api/flights/" + from + "/" + to + "/" + date + "/" + tickets);
            EntityV2.Airline a2 = gson.fromJson(kaffeAirline, EntityV2.Airline.class);
            airlines.add(a2);

        } catch (FlightException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        return gson.toJson(airlines);
        //return dp.GetHttpRequest("http://airline-plaul.rhcloud.com/api/flightinfo/" + from + "/" + to + "/" + date + "/" + tickets);
    }
}
