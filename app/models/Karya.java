package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Karya extends Model {
    public String judul;

    @Column(columnDefinition = "TEXT")
    public String deskripsi;

    @ManyToOne
    public User user;

    @ManyToOne
    public Genre genre;

    public String toString() {
        return this.judul;
    }

}