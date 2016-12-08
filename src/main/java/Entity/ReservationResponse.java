/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Joachim
 */
@NamedQueries({
    @NamedQuery(name="ReservationResponse.selectAllFromUser", query="SELECT r FROM ReservationResponse r WHERE r.user = r.user")
})
@Entity
public class ReservationResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Expose
    private String flightNumber;
    @Expose
    private String origin;
    @Expose
    private String destination;
    @Expose
    private String date;
    @Expose
    private int flightTime;
    @Expose
    private int numberOfSeats;
    @Expose
    private String reserveeName;
    @OneToMany(mappedBy = "reservationResponse")
    private List<Passenger> resPassengers = new ArrayList<>();
    @ManyToOne
    private User user;

    public ReservationResponse(String flightNumber, String origin, String destination, String date, int flightTime, int numberOfSeats, String reserveeName) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.flightTime = flightTime;
        this.numberOfSeats = numberOfSeats;
        this.reserveeName = reserveeName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public ReservationResponse() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
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

    public Integer getId() {
        return id;
    }

    public void setResPassengers(List<Passenger> resPassengers) {
        this.resPassengers = resPassengers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addPassenger(Passenger p) {
        resPassengers.add(p);
        p.setReservationResponse(this);
    }

    public List<Passenger> getResPassengers() {
        return this.resPassengers;
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
        if (!(object instanceof ReservationResponse)) {
            return false;
        }
        ReservationResponse other = (ReservationResponse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
