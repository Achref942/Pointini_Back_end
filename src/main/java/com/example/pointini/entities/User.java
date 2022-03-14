package com.example.pointini.entities;
import org.hibernate.type.TextType;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;



@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private TextType adresse;
    private double salaire;
    private LocalDateTime heure_deb;
    private LocalDateTime heure_fin;
    private Date date_creation;
    private Date date_fin_contrat;
    private String username;
    private String password;

    @ManyToOne
    private Role role;

    public User(Long id, String nom, String prenom, String email, TextType adresse, double salaire, LocalDateTime heure_deb, LocalDateTime heure_fin, Date date_creation, Date date_fin_contrat, String username, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.salaire = salaire;
        this.heure_deb = heure_deb;
        this.heure_fin = heure_fin;
        this.date_creation = date_creation;
        this.date_fin_contrat = date_fin_contrat;
        this.username = username;
        this.password = password;
    }



    public User() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TextType getAdresse() {
        return adresse;
    }

    public void setAdresse(TextType adresse) {
        this.adresse = adresse;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public LocalDateTime getHeure_deb() {
        return heure_deb;
    }

    public void setHeure_deb(LocalDateTime heure_deb) {
        this.heure_deb = heure_deb;
    }

    public LocalDateTime getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(LocalDateTime heure_fin) {
        this.heure_fin = heure_fin;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_fin_contrat() {
        return date_fin_contrat;
    }

    public void setDate_fin_contrat(Date date_fin_contrat) {
        this.date_fin_contrat = date_fin_contrat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
