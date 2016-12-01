package Interface;

import Entity.Airport;
import Entity.Flight;
import java.util.List;

/**
 * @author Joachim
 */
public interface IFlightFacade {
    
    //Fetches a flight based on the flightId
    public Flight getFlight(Integer id);
    
    //Adds a flight to the DB, taking a flight object and converts it.
    public boolean addFlight(Flight flight);
    
    //Removes a flight-object from the DB based on its Id.
    public Boolean deleteFlight(Integer id);
 
    //Creates a list with Flight-Objects from all Flights in DB.  
    public List<Flight> getAllFlights();
    
    //Adds a flight instance, from an object to the DB.
    //public FlightInstance addFlightInstance(FlightInstance flightInstance);
    
    //Adds an Airport to the DB, based on the object.
    public Airport addAirport(Airport airport);
    
    //Creates a list with Flight-Objects from all Flights in DB fitting the criteria
    public List<Flight> getFlightsFromDate(String origin, String date, int seats);
    
    public List<Flight> getFlightsFromTo(String origin, String destination, String date, int seats);
    
}
