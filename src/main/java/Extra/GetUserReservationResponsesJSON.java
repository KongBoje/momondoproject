/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import Entity.Passenger;
import Entity.ReservationResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

/**
 *
 * @author Lasse
 */
public class GetUserReservationResponsesJSON {

    public static String ReservationResponseToJson(List<ReservationResponse> rlist) {

        JsonArray tmp = new JsonArray();

        for (ReservationResponse x : rlist) {
            JsonObject jo = new JsonObject();
            jo.addProperty("flightNumber", x.getFlightNumber());
            jo.addProperty("origin", x.getOrigin());
            jo.addProperty("destination", x.getDestination());
            jo.addProperty("date", x.getDate());
            jo.addProperty("flightTime", x.getFlightTime());
            jo.addProperty("numberOfSeats", x.getNumberOfSeats());
            jo.addProperty("reserveeName", x.getReserveeName());

            JsonArray tmp2 = new JsonArray();
            {
                for (Passenger p : x.getResPassengers()) {
                    JsonObject tmp3 = new JsonObject();
                    tmp3.addProperty("firstName", p.getFirstName());
                    tmp3.addProperty("lastName", p.getLastName());

                    tmp2.add(tmp3);
                }
            }
            jo.add("passengers", tmp2);

            tmp.add(jo);
        }

        return tmp.toString();
    }
}
