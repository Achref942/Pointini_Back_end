package com.example.pointini.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Role implements Serializable {
    @Id
    private Long id;
    private String libelle;

    //@JsonIgnore
    @OneToMany(mappedBy="role")
    private List<User> user;

    public Role(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
