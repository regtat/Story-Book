package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Episode extends Model {
    public int no_eps;
    public String judul;

    @Column(columnDefinition = "TEXT")
    public String cerita;

    @ManyToOne
    public Karya karya;

    public String toString() {
        return String.valueOf(this.id);
    }

    
}