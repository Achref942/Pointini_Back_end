package com.example.pointini.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    @Id
    private Long id;
    private String libelle;

    //@JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<User> user;

}