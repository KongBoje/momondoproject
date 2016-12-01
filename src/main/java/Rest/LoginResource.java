/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.User;
import Extra.LoginObject;
import Extra.LoginResponseObject;
import Facade.UserFacade;
import com.google.gson.Gson;
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
 * @author Michael
 */
@Path("login")
public class LoginResource {

    private static final Gson GSON = new Gson();
    private static final UserFacade UF = new UserFacade();

    @Context
    private UriInfo context;

    public LoginResource() {
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String visit() {
        return "Use the API with POST.";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(String json) {
        try {
            LoginObject LO = GSON.fromJson(json, LoginObject.class);

            User tmp = UF.getUserByCredentials(LO.getUsername(), LO.getPassword());

            LoginResponseObject lro = new LoginResponseObject(tmp);

            return GSON.toJson(lro);
        } catch (Exception ex) {
            User tmpFail = new User("failure", "a", "b", "c", "d");
            LoginResponseObject failure = new LoginResponseObject(tmpFail);
            
            return GSON.toJson(failure);
        }
    }
}
