/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lasse
 */
@Entity
public class ReservationRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    private String flightID;
    @Expose
    private int numberOfSeats;
    @Expose
    private String reserveeName;
    @Expose
    private String reservePhone;
    @Expose
    private String reserveeEmail;
    @Expose
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public ReservationRequest(Long id, String flightID, String reserveeName, String reservePhone, String reserveeEmail) {
        this.id = id;
        this.flightID = flightID;
        this.numberOfSeats = numberOfSeats;
        this.reserveeName = reserveeName;
        this.reservePhone = reservePhone;
        this.reserveeEmail = reserveeEmail;
        this.numberOfSeats = 0;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveeName() {
        return reserveeName;
    }

    public void setReserveeName(String reserveeName) {
        this.reserveeName = reserveeName;
    }

    public String getReservePhone() {
        return reservePhone;
    }

    public void setReservePhone(String reservePhone) {
        this.reservePhone = reservePhone;
    }

    public String getReserveeEmail() {
        return reserveeEmail;
    }

    public void setReserveeEmail(String reserveeEmail) {
        this.reserveeEmail = reserveeEmail;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger p) {
        this.passengers.add(p);
        this.numberOfSeats++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationRequest)) {
            return false;
        }
        ReservationRequest other = (ReservationRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReservationRequest[ id=" + id + " ]";
    }

}
