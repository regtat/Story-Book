package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class User extends Model {
    public String username;
    public String password;
    public String fullname;
    public boolean isAdmin;

    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public String toString() {
        return this.username;
    }
    
}