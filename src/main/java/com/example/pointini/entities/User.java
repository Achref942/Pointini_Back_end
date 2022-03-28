package com.example.pointini.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.TextType;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(unique=true, nullable=false)
    private String email;
    private TextType adresse;
    private double salaire;
    private LocalDateTime heure_deb;
    private LocalDateTime heure_fin;
    private Date date_creation;
    private Date date_fin_contrat;
    private String username;
    private String password;

    @JsonIgnore
    @ManyToOne
    private Role role;



}
