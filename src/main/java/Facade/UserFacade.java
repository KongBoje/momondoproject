/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Flight;
import Entity.User;
import Interface.IUserFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class UserFacade implements IUserFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmp");
    private static EntityManager em = emf.createEntityManager();
    
    @Override
    public User getUser(Integer id) {
    
        User u = null;
        try {
            u = em.find(User.class, id);            
        } finally {
            em.close();
        }
        return u;
        
    }

    @Override
    public boolean addUser(User u) {
        
            try {
                em.getTransaction().begin();
                em.persist(u);
                em.getTransaction().commit();
            } catch(Exception e){
                    return false;
                    }
            
            finally {
                em.close();
                
            }
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        
        User u = null;
        try {
            em.getTransaction().begin();
            u = em.find(User.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return true;
        
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = em.createQuery("SELECT e FROM User e").getResultList();

        em.close();
        return result;
    }
    
}
