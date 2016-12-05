/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.ReservationRequest;
import Entity.ReservationResponse;
import Entity.User;
import EntityV2.ReservationSetup;
import Exceptions.FlightException;
import Extra.DownloadProxy;
import Facade.UserFacade;
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

    private static final Gson gson = new Gson();
    private static final DownloadProxy dp = new DownloadProxy();
    private static final UserFacade uf = new UserFacade();

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
     * @param reservationRequestSetting
     * @return an instance of java.lang.String
     * @throws Exceptions.FlightException
     */
    @POST
    @Path("/{flightId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("flightId") String flightId, String reservationRequestSetting) throws FlightException {
        System.out.println(reservationRequestSetting);
        
        ReservationSetup rs = gson.fromJson(reservationRequestSetting, ReservationSetup.class);
        
        ReservationRequest request = rs.getBody();
        
        String url = rs.getUrl();
        String body = gson.toJson(rs.getBody(), ReservationRequest.class);
        
        if(url.equals("http://airline-plaul.rhcloud.com/")) {
            url = "http://airline-plaul.rhcloud.com/api/flightreservation/";
        } else {
            url += "api/reservation/" + request.getFlightID();
        }
        
        String response = dp.PostHttpRequest(url, body);
        
        ReservationResponse json = gson.fromJson(response, ReservationResponse.class);
        
        User updateMe = uf.getUser(rs.getUserid());
        
        System.out.println("The user is " + updateMe.getRealName());
        System.out.println("The reservation is by " + json.getReserveeName());
        
        uf.addResponseToUser(updateMe, json);
        
        return response;
    }
}
