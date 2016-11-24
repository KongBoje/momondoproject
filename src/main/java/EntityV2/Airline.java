/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityV2;

import java.util.ArrayList;

/**
 *
 * @author Lasse
 */
public class Airline {
    private final String airline;
    private final ArrayList<EntityV2.Flight> flights;
    
    public Airline(String a) {
        airline = a;
        flights = new ArrayList<>();
    }
    
    public void addFlight(EntityV2.Flight f) {
        flights.add(f);
    }
    
    public ArrayList<EntityV2.Flight> getFlights() {
        return flights;
    }
}
