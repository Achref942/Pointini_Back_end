package com.example.pointini.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Role implements Serializable {
    @Id
    private int id;
    private String libelle;
    @OneToMany (mappedBy="id")
    private List<User> user;

    public Role(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
