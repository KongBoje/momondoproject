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
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmp");
    private static EntityManager em = emf.createEntityManager();
    
    public FlightFacade() {
        
    }

    @Override
    public Flight getFlight(Integer id) {
        Flight F = null;
        try {
            F = em.find(Flight.class, id);
        } finally {
            em.close();
        }
        return F;
        
    }

    @Override
    public Flight addFlight(Flight flight) {
        Flight f = flight;
            try {
                em.getTransaction().begin();
                em.persist(f);
                em.getTransaction().commit();
            } finally {
                //em.close();
            }
        return f;
    }

    @Override
    public Boolean deleteFlight(Long id) {
        Flight f = null;
        try {
            em.getTransaction().begin();
            f = em.find(Flight.class, id);
            em.remove(f);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> result = em.createQuery("SELECT e FROM Flight e").getResultList();

        em.close();
        return result;
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
