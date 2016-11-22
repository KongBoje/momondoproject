/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestException;

/**
 *
 * @author Lasse
 */
import javax.ws.rs.NotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Context
  ServletContext context;

  @Override
  public Response toResponse(NotFoundException ex) {
    JsonObject errorDetail = new JsonObject();
    int statusCode = ex.getResponse().getStatus();
    errorDetail.addProperty("code", statusCode);
    errorDetail.addProperty("message", "The requested resource was not found on our server");
    return Response.status(statusCode).entity(gson.toJson(errorDetail)).type(MediaType.APPLICATION_JSON).build();
  }
}
