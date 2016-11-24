/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import Entity.Flight;
import Facade.FlightFacade;
import Interface.IFlightFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class Tests {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("mmp");
    }

    @After
    public void destroy() {
        entityManagerFactory.close();
    }

    @Test
    public void connection() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Flight flight = new Flight();
        entityManager.persist(flight);

        Flight dbFlight = entityManager.createQuery(
                "select e "
                + "from Flight e", Flight.class)
                .getSingleResult();
        assertEquals(flight.getFlightId(), dbFlight.getFlightId());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    @Test
    public void testGetFlight(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        FlightFacade fc = new FlightFacade();
        Flight flight = new Flight();
        fc.addFlight(flight);
        assertTrue(fc.getFlight(flight.getId()).equals(flight));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
