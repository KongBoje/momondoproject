package setupTestData;

import Entity.Flight;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class setupData {
    public static void setup() {

    /*Generate schema 1 gang og derefter udkommenter det.*/
        GenerateSchema gs = new GenerateSchema();
        gs.initSchema();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmp");
        EntityManager em = emf.createEntityManager();
        
        /*Create flight*/
        Flight f = new Flight();
        Flight f1 = new Flight();
        Flight f2 = new Flight();
        Flight f3 = new Flight();
        Flight f4 = new Flight();
        
        f.setFlightId("5342-5374581236347");
        f.setFlightNumber("KAF6666");
        f.setDate("2017-11-22T12:00:00.000Z");
        f.setSeats(6);
        f.setTotalPrice(67);
        f.setFlightTime(240);
        f.setOrigin("CPH");
        f.setDestination("MOW");
        
        
        f1.setFlightId("4443-8765989054363");
        f1.setFlightNumber("KAF3466");
        f1.setDate("017-12-03T16:00:00.000Z");
        f1.setSeats(9);
        f1.setTotalPrice(239);
        f1.setFlightTime(120);
        f1.setOrigin("CPH");
        f1.setDestination("STN");
        
        f2.setFlightId("2323-8675048485030");
        f2.setFlightNumber("KAF6622");
        f2.setDate("2018-03-12T15:00:00.000Z");
        f2.setSeats(4);
        f2.setTotalPrice(190);
        f2.setFlightTime(60);
        f2.setOrigin("STN");
        f2.setDestination("SXF");
        
        f3.setFlightId("8765-0101909245668");
        f3.setFlightNumber("KAF5789");
        f3.setDate("2017-01-05T12:00:00.000Z");
        f3.setSeats(12);
        f3.setTotalPrice(300);
        f3.setFlightTime(264);
        f3.setOrigin("STN");
        f3.setDestination("CPH");
        
        f4.setFlightId("6464-0192837465951");
        f4.setFlightNumber("KAF1113");
        f4.setDate("2017-02-01T12:00:00.000Z");
        f4.setSeats(14);
        f4.setTotalPrice(200);
        f4.setFlightTime(210);
        f4.setOrigin("SXF");
        f4.setDestination("CPH");
        
        em.getTransaction().begin();
        em.persist(f);
        em.persist(f1);
        em.persist(f2);
        em.persist(f3);
        em.persist(f4);
        em.getTransaction().commit();
        em.close();
    }
    public static void main(String[] args) {
        setup();
    }
}
