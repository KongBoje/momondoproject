/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotJUnit;

import Entity.ReservationResponse;
import Facade.UserFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lasse
 */
public class NewClass {
    
    
    public static void main(String[] args) {
        UserFacade uf = new UserFacade();
        List<ReservationResponse> tmp = uf.getUser(4).getReservations();
        
        for(ReservationResponse x : tmp) {
            System.out.println(x.getDate());
        }
    }
}
