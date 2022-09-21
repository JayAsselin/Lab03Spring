package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Cours {

    @Pattern(regexp = "^([A-Z0-9]{6,15})$", message = "Le numero de cours doit comporter entre" +
            " 6 et 15 characteres alphanumerique")
    private String numero;
    @NotEmpty(message = "Le nom de cours ne peut pas etre vide")
    private String intituler;

    @Min(value = 0)
    @Max(value = 100, message = "Le nombre de credit doit etre entre 0 et 100")
    private int nombreCredit;

    @Min(value = 1, message = "Le nombre de session est minimum 1")
    @Max(value = 4, message="Le nombre de session ne peut pas depaser 4")
    private int session;

    @Pattern(regexp= "^(\\w+-?\\s?)+(\\.pdf|\\.doc)$", message = "Le nom de fichier doit " +
            "comporter des charactere alphanumerique, un ou des espaces, tiret et" +
            "terminer avec .pdf ou .doc")
    private String nomFichier;

    public Cours() {
    }

    public Cours(String numero, String intituler, int nombreCredit, int session,
                 String nomFichier) {
        this.numero = numero;
        this.intituler = intituler;
        this.nombreCredit = nombreCredit;
        this.session = session;
        this.nomFichier = nomFichier;
    }
}
