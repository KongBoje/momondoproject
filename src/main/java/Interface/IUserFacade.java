/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.ReservationResponse;
import Entity.User;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface IUserFacade {

    public User getUser(Integer id);
    
    public boolean addUser(User u);
    
    public boolean deleteUser(Integer id);
    // TODO: Fix for foreign key relatoins
    
    public List<User> getAllUsers();
    
    public void addResponseToUser(User u, ReservationResponse r);
}
