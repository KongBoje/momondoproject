/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions.FlightException;
import Extra.DownloadProxy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lasse
 */
@Path("wrapreservation")
public class ReservationResource {

    private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private static final DownloadProxy dp = new DownloadProxy();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReservationResource
     */
    public ReservationResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.ReservationResource
     *
     * @param flightId
     * @param reservationRequestBody
     * @return an instance of java.lang.String
     * @throws Exceptions.FlightException
     */
    @POST
    @Path("/{flightId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("flightId") String flightId, String reservationRequestBody) throws FlightException {
        String link = "http://airline-plaul.rhcloud.com/api/flightreservation";
        return dp.PostHttpRequest(link, reservationRequestBody);
    }
}
