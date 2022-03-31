package com.example.pointini.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    // type image ?
    private String logo;
    private String matriculeFiscale;
    private Date dateCreation;
    private double prixHeurSup;
    private double nbCongePMois;
    private Date expirationPack;
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "entreprise_pack",
            joinColumns = {@JoinColumn(name = "Entreprise_id" ,referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "Pack_id",referencedColumnName = "id")}
    )
    private List<Pack> pack =new ArrayList<>();

}
