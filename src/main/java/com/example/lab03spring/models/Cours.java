package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cours {

    private String numero;
    private String intituler;
    private int nombreCredit;
    private int session;
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
