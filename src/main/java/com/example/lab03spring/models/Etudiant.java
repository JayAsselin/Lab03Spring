package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Etudiant {

    @Pattern(regexp = "^\\d{6}$", message = "Le NAS doit contenir 6 chiffres ex: 123456")
    private String nas;
    @NotEmpty(message = "Vous devez entrer un nom")
    private String nom;
    @NotEmpty(message = "Vous devez entrer un prenom")
    private String prenom;
    @Pattern(regexp = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$", message = "Le numero de telephone doit " +
            "etre dans le format suivant (XXX) XXX-XXXX")
    private String telephone;
    @Pattern(regexp = "^\\d{1,4}\\s([A-z]+\\s?)+$", message = "L'adresse doit commencer par le " +
            "numero civique suivi du nom de la rue, ville, etc.")
    private String adresse;
    @Pattern(regexp = "^[A-Z]\\d[A-Z]\\s\\d[A-Z]\\d$", message ="Le code postal doit respecter le" +
            " format suivant ex: A9F 2L3")
    private String codePostal;
    @Email(message = "Vous devez entrer un courriel valide")
    private String courriel;
    private char genre;

    public Etudiant() {
    }

    public Etudiant(String nas, String nom, String prenom, String telephone, String adresse,
                    String codePostal,
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
