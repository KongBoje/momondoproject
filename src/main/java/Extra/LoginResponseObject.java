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
    private final String userName;
    private final String password;
    private final String realName;
    private final String email;
    private final String phone;
    
    public LoginResponseObject(User u) {
        this.id = u.getId();
        this.userName = u.getUserName();
        this.password = u.getPassword();
        this.realName = u.getRealName();
        this.email = u.getEmail();
        this.phone = u.getPhone();
    }
}
