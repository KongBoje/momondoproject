/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Lasse
 */
public class FakeReservationResponse {
    // GSON doesn't handle objects within objects
    private final String flightID;
    private final int numberOfSeats;
    private final String reserveeName;
    private final String reservePhone;
    private final String reserveeEmail;
    private final String passengers;

    public FakeReservationResponse(String flightID, int numberOfSeats, String reserveeName, String reservePhone, String reserveeEmail, String passengers) {
        this.flightID = flightID;
        this.numberOfSeats = numberOfSeats;
        this.reserveeName = reserveeName;
        this.reservePhone = reservePhone;
        this.reserveeEmail = reserveeEmail;
        this.passengers = passengers;
    }

    public String getFlightID() {
        return flightID;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getReserveeName() {
        return reserveeName;
    }

    public String getReservePhone() {
        return reservePhone;
    }

    public String getReserveeEmail() {
        return reserveeEmail;
    }

    public String getPassengers() {
        return passengers;
    }
    
    
}
