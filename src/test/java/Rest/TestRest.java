/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

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
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Lasse
 */
public class TestRest {

    
    
    
    private final String base = "http://localhost:8084/Momondoproject";
    private static final Gson gson = new Gson();

    @Test
    public void testRestConnect() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
    
    /*
    @Test
    public void testRestFlightFromDateMalformed() {
        // SFX does not exist, so please fail
        given().when().get(base + "/api/flights/SFX/2017-11-23T00:00:00.000Z/1").then().statusCode(400);
    }
    
    @Test
    public void testRestFlightFromDateOkay() {
        given().when().get(base + "/api/flights/CPH/2017-11-23T00:00:00.000Z/1").then().statusCode(200);
    }
    */
    
    @Test
    public void testDownloadProxyGet() throws FlightException {
        DownloadProxy dp = new DownloadProxy();
        String res = dp.GetHttpRequest("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-11-11T00:00:00.000Z/1");
    }

    @Test (expected = FlightException.class)
    public void testDownloadProxyGetMalformed() throws FlightException {
        DownloadProxy dp = new DownloadProxy();
        String res = dp.GetHttpRequest("http://www.ekstraaaaaaaaaaaaaaaabladet.dk");
    }
    
    @Test
    public void testDownloadProxyPost() throws FlightException {
        DownloadProxy dp = new DownloadProxy();
        
        String body = "{  \n" +
"  \"flightID\": \"3256-1513036800000\",\n" +
"  \"numberOfSeats\":1,\n" +
"  \"reserveeName\":\"Jan Hansen\",\n" +
"  \"reservePhone\":\"12345678\",\n" +
"  \"reserveeEmail\":\"jan@hansen.dk\",\n" +
"  \"passengers\":[  \n" +
"    {  \n" +
"      \"firstName\":\"Jan\",\n" +
"      \"lastName\":\"Hansen\"\n" +
"    }\n" +
"  ]\n" +
"}";
        String link = "http://airline-plaul.rhcloud.com/api/flightreservation";
        
        String res = dp.PostHttpRequest(link, body);
    }

    // Does work but must be refactored since travis doesnt run the main project
    
    /*
    @Test
    public void testRestException() {
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
