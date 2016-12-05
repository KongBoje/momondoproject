/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Flight;
import Entity.ReservationRequest;
import Entity.ReservationResponse;
import Interface.IReservationFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class ReservationFacade implements IReservationFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmp");
    private static EntityManager em = emf.createEntityManager();

    @Override
    public ReservationResponse getReservationResponseById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addReservationResponse(ReservationResponse rr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteReservationResponse(ReservationResponse rr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReservationResponse> getAllReservationResponses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
