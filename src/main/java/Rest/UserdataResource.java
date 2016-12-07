/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.ReservationResponse;
import Entity.User;
import Extra.GetUserReservationResponsesJSON;
import Facade.UserFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lasse
 */
@Path("userdata")
public class UserdataResource {

    private static final UserFacade UF = new UserFacade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserdataResource
     */
    public UserdataResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.UserdataResource
     *
     * @param userid
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("userid") int userid) {
        User tmp = UF.getUser(userid);
        List<ReservationResponse> responses = tmp.getReservations();

        return GetUserReservationResponsesJSON.ReservationResponseToJson(responses);
    }

}
