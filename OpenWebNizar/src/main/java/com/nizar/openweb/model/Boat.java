package com.nizar.openweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Entités Boat //

@Entity
@Table( name = "boat" )
public class Boat {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long   id;

    @ManyToOne
    @JoinColumn( name = "id_client" )
    private User   user;

    private String boatname;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    public String getBoatname() {
        return boatname;
    }

    public void setBoatname( String boatname ) {
        this.boatname = boatname;
    }

}
