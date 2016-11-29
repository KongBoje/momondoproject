//package JUnit;
//
//import Entity.Flight;
//import Facade.FlightFacade;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.Persistence;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
//
///**
// * @author Joachim
// */
//public class FacadeTest {
//    FlightFacade ff = new FlightFacade();
//    public FacadeTest() {
//        Persistence.generateSchema("mmp", null);
//    }
////    @Test
////    public void flightCreation(){
////        Flight testFlight = new Flight(2983248, 2354124, "butts", 34, 333, 203.33, 2143, "CPH", "MOW");
////        ff.addFlight(testFlight);
////        assertEquals(testFlight, ff.getFlight(testFlight.getId()));
////    }
////    @Test
////    public void flightSearchFrom() {
////        Flight testFlight1 = new Flight("2983248", "2354124", "butts", 34, 333, 203.33, 2143, "CPP", "MOW");
////        Flight testFlight2 = new Flight("2983248", "2354124", "butts", 34, 333, 203.33, 2143, "CPP", "MOW");
////        ff.addFlight(testFlight1);
////        ff.addFlight(testFlight2);
////        List<Flight> flights = new ArrayList<>();
////        flights.add(testFlight1);
////        flights.add(testFlight2);
////        assertEquals(flights, ff.getFlightsFromDate("CPP", "butts", 34));
////    }
//    @Test
//    public void flightSearchFromAndTo() {
//        Flight testFlight1 = new Flight("2983248", "2354124", "butts", 34, 333, 2143, "CPP", "MOW");
//        Flight testFlight2 = new Flight("2983248", "2354124", "butts", 34, 333, 2143, "CPP", "MOW");
//        ff.addFlight(testFlight1);
//        ff.addFlight(testFlight2);
//        List<Flight> flights = new ArrayList<>();
//        flights.add(testFlight1);
//        flights.add(testFlight2);
//        assertEquals(flights, ff.getFlightsFromTo("CPP", "MOW", "butts", 34));
//    }
//}
