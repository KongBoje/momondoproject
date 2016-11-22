/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestException;

import Exceptions.FlightException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Lasse
 */
@Provider
public class FlightExceptionMapper implements ExceptionMapper<FlightException> {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    ServletContext context;

    @Override
    public Response toResponse(FlightException ex) {
        JsonObject errorDetail = new JsonObject();
        errorDetail.addProperty("httpError", ex.httpError);
        errorDetail.addProperty("errorCode", ex.errorCode);
        errorDetail.addProperty("message", ex.message);
        
        return Response.status(ex.httpError).entity(gson.toJson(errorDetail)).type(MediaType.APPLICATION_JSON).build();
    }
}
