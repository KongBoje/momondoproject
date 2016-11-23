/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions.FlightException;
import Extra.DownloadProxy;
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
@Path("reservation")
public class ReservationResource {

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
     * @param reservationRequest
     * @return an instance of java.lang.String
     * @throws java.io.IOException
     */
    @POST
    @Path("/{flightId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("flightId") String flightId, String reservationRequest) throws FlightException {
        String link = "http://airline-plaul.rhcloud.com/api/flightreservation/";

        String body = "{  \n"
                + "  \"flightID\": \"3256-1513036800000\",\n"
                + "  \"numberOfSeats\":1,\n"
                + "  \"reserveeName\":\"Jan Hansen\",\n"
                + "  \"reservePhone\":\"12345678\",\n"
                + "  \"reserveeEmail\":\"jan@hansen.dk\",\n"
                + "  \"passengers\":[  \n"
                + "    {  \n"
                + "      \"firstName\":\"Jan\",\n"
                + "      \"lastName\":\"Hansen\"\n"
                + "    }\n"
                + "  ]\n"
                + "}";

        return dp.PostHttpRequest(link, body);

    }
}
