/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions.FlightException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import static io.restassured.http.ContentType.JSON;
import java.io.StringReader;
import javax.json.Json;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Lasse
 */
public class TestRest {

    // Does work but must be refactored since travis doesnt run the main project
    
    /*
    
    private final String base = "http://localhost:8084/Momondoproject";
    private static final Gson gson = new Gson();

    @Test
    public void testConnect() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }

    @Test
    public void testException() {
        given().when().get(base + "/api/THISDOESNOTEXIST").then().statusCode(404);
        
        String res = given().when().get(base + "/api/exception").then().statusCode(400).extract().response().asString();
        
        FlightException resEx = gson.fromJson(res, FlightException.class);
        
        assertTrue(resEx.httpError == 400);
        assertTrue(resEx.errorCode == 1);
        assertTrue(resEx.message.equals("No flights"));
        
        System.out.println(res);
    }
    
    */
}
