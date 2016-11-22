/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lasse
 */
@Path("reservation")
public class ReservationResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReservationResource
     */
    public ReservationResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.ReservationResource
     * @param reservationRequest
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/{flightId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(String reservationRequest) {
        throw new UnsupportedOperationException();
    }
}
