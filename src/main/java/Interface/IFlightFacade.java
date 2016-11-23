package Interface;

import Entity.Airport;
import Entity.Flight;
import Entity.FlightInstance;
import java.util.List;

/**
 * @author Joachim
 */
public interface IFlightFacade {
    
    //Fetches a flight based on the flightId
    Flight getFlight(Long id);
    
    //Adds a flight to the DB, taking a flight object and converts it.
    Flight addFlight(Flight flight);
    
    //Removes a flight-object from the DB based on its Id.
    Boolean deleteFlight(Long id);
 
    //Creates a list with Flight-Objects from all Flights in DB.  
    List<Flight> getAllFlights();
    
    //Adds a flight instance, from an object to the DB.
    FlightInstance addFlightInstance(FlightInstance flightInstance);
    
    //Adds an Airport to the DB, based on the object.
    Airport addAirport(Airport airport);
    
}
