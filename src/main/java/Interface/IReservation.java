/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Reservation;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface IReservation {

//Fetches a reservation based on the reservation's Id
Reservation getReservation(Integer id);

//Adds a reservation to the DB, taking a reservation object and converts it 
Reservation addFlight(Reservation reservation);

//Removes a reservation-object from the DB basted on its id.
Boolean deleteReservation(Long id);    
    
//Creates List of reservation from all reservation instances.
List<Reservation> getAllReservations();

}
