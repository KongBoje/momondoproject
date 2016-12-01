/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import Entity.User;

/**
 *
 * @author Lasse
 */
public class LoginResponseObject {
    private final int id;
    private final String username;
    // private final String password;
    private final String realname;
    private final String email;
    private final String phone;
    
    public LoginResponseObject(User u) {
        this.id = u.getId();
        this.username = u.getUserName();
        //this.password = u.getPassword();
        this.realname = u.getRealName();
        this.email = u.getEmail();
        this.phone = u.getPhone();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    
}
