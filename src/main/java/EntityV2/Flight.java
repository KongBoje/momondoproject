/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityV2;

/**
 *
 * @author Lasse
 */
public class Flight {
    private final String flightID;
    private final String flightNumber;
    private final String date;
    private final int numberOfSeats;
    private final int totalPrice;
    private final int traveltime;
    private final String origin;
    private final String destination;

    public Flight(String flightID, String flightNumber, String date, int numberOfSeats, int totalPrice, int traveltime, String origin, String destination) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.date = date;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
        this.traveltime = traveltime;
        this.origin = origin;
        this.destination = destination;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getTraveltime() {
        return traveltime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
    
    
}
