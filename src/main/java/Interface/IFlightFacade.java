package Interface;

import Entity.Airport;
import Entity.Flight;
import Entity.FlightInstance;
import java.util.List;

/**
 * @author Joachim
 */
public interface IFlightFacade {
    Flight getFlight(int id);
    Flight addFlight(Flight flight);
    Flight deleteFlight(int id);
    List<Flight> getAllFlights();
    
    FlightInstance addFlightInstance(FlightInstance flightInstance);
    Airport addAirport(Airport airport);
    
}
