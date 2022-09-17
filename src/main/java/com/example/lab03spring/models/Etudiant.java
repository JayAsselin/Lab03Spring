package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Etudiant {

    private int nas;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String codePostal;
    private String courriel;
    private char genre;

    public Etudiant() {
    }

    public Etudiant(int nas, String nom, String prenom, String telephone, String adresse, String codePostal,
                    String courriel, char genre) {
        this.nas = nas;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.courriel = courriel;
        this.genre = genre;
    }
}
