package Facade;

import Entity.Airport;
import Entity.Flight;
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
    public boolean addFlight(Flight flight) {
        //Flight f = flight;
            try {
                em.getTransaction().begin();
                em.persist(flight);
                em.getTransaction().commit();
            } finally {
                //em.close();
            }
        return true;
    }

    @Override
    public Boolean deleteFlight(Integer id) {
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
    public List<Flight> getFlightsFromDate(String origin, String date, int seats) {
        List<Flight> result = em.createQuery("SELECT e FROM Flight e WHERE e.origin = :origin AND e.date = :date AND e.numberOfSeats = :seats").setParameter("origin", origin).setParameter("date", date).setParameter("seats", seats).getResultList();

        //em.close();
        return result;
    }

    @Override
    public List<Flight> getFlightsFromTo(String origin, String destination, String date, int seats) {
        List<Flight> result = em.createQuery("SELECT e FROM Flight e WHERE e.origin = :origin AND e.destination = :destination AND e.date = :date AND e.numberOfSeats = :seats").setParameter("origin", origin).setParameter("destination", destination).setParameter("date", date).setParameter("seats", seats).getResultList();

        //em.close();
        return result;
    }

    @Override
    public Airport addAirport(Airport airport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
