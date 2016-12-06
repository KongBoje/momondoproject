/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import Entity.Passenger;
import Entity.ReservationResponse;
import Entity.User;
import Facade.UserFacade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Michael
 */
public class UserTests {

    private static final UserFacade UF = new UserFacade();

    @Test
    public void testGetUserTest() {
        User u = new User("Anders And", "productowner", "business", "11122233", "productowner@productowners.com");
        UF.addUser(u);

        assertTrue(UF.getUser(u.getId()).getRealName().equals("Anders And"));
    }

    @Test
    public void testDeleteUser() {
        User u = new User("Knud", "antonmarly", "ajsfdaoihd", "333444", "knud@test.dk");

        UF.addUser(u);
        int before = UF.getAllUsers().size();
        UF.deleteUser(u.getId());
        int after = UF.getAllUsers().size();

        assertTrue(before > after);
    }

    @Test
    public void testGetAllUsers() {
        User a = new User("Anton", "FaceShaman", "sihfs", "123", "aaa@bbb.ccc");
        User b = new User("Marley", "Bobsaget", "sdjfsd", "54556545", "ddd@rrr.ggg");
        UF.addUser(a);
        UF.addUser(b);

        assertTrue(a.getId() != null);
        assertTrue(b.getId() != null);

        List<User> res = UF.getAllUsers();

        assertTrue(res.size() > 0);

    }

    @Test
    public void testAddReservation() {
        User u = new User("Hans", "oplader123", "password", "45612300", "hc@andersen.dk");
        UF.addUser(u);

        assertTrue(u.getReservations().isEmpty());

        ReservationResponse r = new ReservationResponse("testnumber", "testorigin", "testdestination", "testdate", 180, 2, "testreservee");
 
        Passenger p = new Passenger("Barrack", "Obama");
        Passenger pp = new Passenger("Kurt", "Koben");        

        r.addPassenger(p);
        r.addPassenger(pp);
        
        UF.addResponseToUser(u, r);
        
        for(ReservationResponse x : u.getMySeats()) {
            System.out.println(x.getReserveeName());
        }

        // assertTrue(u.getReservations().size() == 1);
    }

}
