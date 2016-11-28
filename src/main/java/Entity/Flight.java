/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Joachim
 */
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flightID;
    private String flightNumber;
    private String date;
    private int numberOfSeats;
    private double totalPrice;
    private int traveltime;
    private String origin;
    private String destination;

    public Flight(String flightID, String flightNumber, String date, int seats, int flightTime, double totalPrice, int time, String origin, String destination) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.date = date;
        this.numberOfSeats = seats;
        this.traveltime = flightTime;
        this.totalPrice = totalPrice;
        this.origin = origin;
        this.destination = destination;
    }

    public Flight() {

    }

    public String getFlightId() {
        return flightID;
    }

    public void setFlightId(String flightId) {
        this.flightID = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeats() {
        return numberOfSeats;
    }

    public void setSeats(int seats) {
        this.numberOfSeats = seats;
    }

    public int getFlightTime() {
        return traveltime;
    }

    public void setFlightTime(int flightTime) {
        this.traveltime = flightTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Flight[ id=" + id + " ]";
    }

}
