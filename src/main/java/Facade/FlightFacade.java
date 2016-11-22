package Facade;

import Entity.Airport;
import Entity.Flight;
import Entity.FlightInstance;
import Interface.IFlightFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Joachim
 */


public class FlightFacade implements IFlightFacade {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("smpu");
    private static EntityManager em = emf.createEntityManager();
    
    public FlightFacade() {
        
    }

    @Override
    public Flight getFlight(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flight addFlight(Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flight deleteFlight(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Flight> getAllFlights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlightInstance addFlightInstance(FlightInstance flightInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Airport addAirport(Airport airport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
