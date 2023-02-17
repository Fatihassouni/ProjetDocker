package com.example.test.Entity;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Nom")
    private String Nom;

    @Column(name = "Prenom")
    private String Prenom;

    @Column(name = "Email")
    private String Email;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String Email) {
        this.Nom = nom;
        this.Prenom = prenom;
        this.Email = Email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Email=" + Email +
                '}';
    }
}


