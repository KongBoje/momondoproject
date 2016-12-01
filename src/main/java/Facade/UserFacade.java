/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.ReservationResponse;
import Entity.User;
import Interface.IUserFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Martin
 */
public class UserFacade implements IUserFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmp");
    // private static EntityManager em = emf.createEntityManager();

    @Override
    public User getUser(Integer id) {
        EntityManager em = emf.createEntityManager();
        User u = null;
        try {
            u = em.createNamedQuery("User.findById", User.class).setParameter("id", id).getSingleResult();
        } finally {
            em.close();
        }
        return u;

    }

    @Override
    public User getUserByCredentials(String userName, String password) {
        EntityManager em = emf.createEntityManager();
        User u = null;
        try {
            Query query = em.createQuery("SELECT e FROM User e WHERE e.userName = :userName AND e.password = :password").setParameter("name", userName).setParameter("password", password);
            u = (User) query.getSingleResult();
        } finally {
            em.close();
        }
        return u;

    }
    
    @Override
    public boolean addUser(User u) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(User.class, id));
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            em.close();
        }

    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> result = em.createNamedQuery("User.findAll", User.class).getResultList();

        em.close();
        return result;
    }

    @Override
    public void addResponseToUser(User u, ReservationResponse r) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        u.addReservation(r);
        em.getTransaction().commit();
        em.close();
    }
}
