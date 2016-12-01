/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Martin
 */
@Entity
@NamedQueries ({
    @NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
    @NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name="User.findByUserName", query="SELECT u FROM User u WHERE u.userName = :userName")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String realName;
    private String userName;
    private String password;
    private String phone;
    private String email;
    @OneToMany
    @ElementCollection
    @CollectionTable(name="mySeats")
    private List<ReservationResponse> mySeats = new ArrayList<>();
    
    public User () {
        
    }

    public User(String realName, String userName, String password, String phone, String email) {
        this.realName = realName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ReservationResponse> getMySeats() {
        return mySeats;
    }

    public void setMySeats(List<ReservationResponse> mySeats) {
        this.mySeats = mySeats;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addReservation(ReservationResponse r){
        mySeats.add(r);
    }
    
    public List<ReservationResponse> getReservations() {
        return this.mySeats;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.User[ id=" + id + " ]";
    }
    
}
