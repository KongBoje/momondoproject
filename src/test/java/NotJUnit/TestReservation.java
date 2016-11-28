/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotJUnit;

import Entity.Passenger;
import Entity.ReservationRequest;
import Entity.ReservationResponse;
import Exceptions.FlightException;
import Extra.DownloadProxy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Lasse
 */
public class TestReservation {
    
    private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    
    public static void main(String[] args) throws FlightException {
        ReservationRequest r = new ReservationRequest(555L, "2335-1510448400000", "Jan Hansen", "12345678", "jan@hansen.dk");
        Passenger p1 = new Passenger("Jan", "Hansen");
        Passenger p2 = new Passenger("Jane", "Hansen");
        
        r.addPassenger(p1);
        r.addPassenger(p2);
        
        System.out.println("=== Create response body");
        String requestBody = gson.toJson(r);
        
        DownloadProxy dp = new DownloadProxy();
        String link = "http://airline-plaul.rhcloud.com/api/flightreservation";
                
        String result = dp.PostHttpRequest(link, requestBody);
        
        System.out.println("=== The response is ... ");
        System.out.println(result);
    }
}
