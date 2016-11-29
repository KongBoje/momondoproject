/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import Exceptions.FlightException;
import Extra.DownloadProxy;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import static io.restassured.http.ContentType.JSON;
import java.io.IOException;
import java.io.StringReader;
import java.rmi.UnknownHostException;
import javax.json.Json;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Lasse
 */
public class TestGET {

    private static final String BASE = "http://localhost:8084/Momondoproject/";

    /*
    @Test
    public void testValidInput() {
        given().when().get(BASE + "api/flights/CPH/2016-11-22T00:00:00.000Z/1").then().statusCode(200);
    }
    
    @Test
    public void testNoFlights() {
        given().when().get(BASE + "api/flights/CPH/0/1").then().statusCode(400)
                .body("httpError", equalTo(400))
                .body("errorCode", equalTo(1))
                .body("message", equalTo("There were no flights"))
                ;
    }
    
    @Test
    public void testInvalidFromInFrom() {
        given().when().get(BASE + "api/flights/TSK/2016-11-22T00:00:00.000Z/1").then().statusCode(400)
                .body("httpError", equalTo(400))
                .body("errorCode", equalTo(3))
                .body("message", equalTo("The from place is invalid"))
                ;
    }
    
    @Test
    public void testInvalidFromInFromTo() {
        given().when().get(BASE + "api/flights/TSK/CPH/2016-11-22T00:00:00.000Z/1").then().statusCode(400)
                .body("httpError", equalTo(400))
                .body("errorCode", equalTo(3))
                .body("message", equalTo("The from place is invalid"))
                ;
    }
    
    @Test
    public void testInvalidToInFromTo() {
        given().when().get(BASE + "api/flights/CPH/TSK/2016-11-22T00:00:00.000Z/1").then().statusCode(400)
                .body("httpError", equalTo(400))
                .body("errorCode", equalTo(3))
                .body("message", equalTo("The to place is invalid"))
                ;
    }
     */
}
