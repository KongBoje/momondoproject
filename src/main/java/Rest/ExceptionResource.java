/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions.FlightException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lasse
 */
@Path("exception")
public class ExceptionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public ExceptionResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.ExceptionResource
     * @return an instance of java.lang.String
     * @throws Exceptions.FlightException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws FlightException {
        //TODO return proper representation object
        throw new FlightException(400, 1, "No flights");
    }

    /**
     * PUT method for updating or creating an instance of ExceptionResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
