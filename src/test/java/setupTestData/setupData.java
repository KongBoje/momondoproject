package setupTestData;

import Entity.Flight;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class setupData {
    public static void setup() {
        /*Generate schema 1 gang og derefter udkommenter det.*/
        GenerateSchema gs = new GenerateSchema();
        gs.initSchema();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmp");
        EntityManager em = emf.createEntityManager();
        
        /*Create flight*/
        Flight f = new Flight();
        f.setFlightId("5342-5374581236347");
        f.setFlightNumber("KAF6666");
        f.setDate("2016-11-22T12:00:00.000Z");
        f.setSeats(6);
        f.setTotalPrice(67);
        f.setTime(240);
        f.setOrigin("CPH");
        f.setDestination("MOW");
        
        
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void main(String[] args) {
        setup();
    }
}
