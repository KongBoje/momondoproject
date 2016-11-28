/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.ReservationResponse;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface IReservationFacade {

//Fetches a reservation based on the reservation's Id
ReservationResponse getReservation(Integer id);

//Adds a reservation to the DB, taking a reservation object and converts it 
<<<<<<< HEAD
ReservationResponse addFlight(ReservationResponse reservation);
=======
Reservation addReservation(Reservation reservation);
>>>>>>> 6ebc45ed29b6f4053cdcc859e14bf73706e6a374

//Removes a reservation-object from the DB basted on its id.
Boolean deleteReservation(Long id);    
    
//Creates List of reservation from all reservation instances.
List<ReservationResponse> getAllReservations();

}
