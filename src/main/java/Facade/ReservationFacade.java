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
    public ReservationResponse getReservation(Integer id) {
    
        ReservationResponse r;
        try {
            r = em.find(ReservationResponse.class, id);
        } finally {
            em.close();
        }
        return r;
        
    }
        
    

    @Override
    public boolean addReservation(ReservationResponse reservation) {
            try {
                em.getTransaction().begin();
                em.persist(reservation);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        return true;
        
    }

    @Override
    public boolean deleteReservation(Long id) {
        try{
            
            em.getTransaction().begin();
            em.find(ReservationResponse.class, id);
            em.remove(id);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
        return true;
    }

    @Override
    public List<ReservationRequest> getAllReservations() {
       List<ReservationRequest> result = em.createQuery("SELECT e FROM ReservationResponse e").getResultList();
       em.close();
       return result;
    }

    
    
}
