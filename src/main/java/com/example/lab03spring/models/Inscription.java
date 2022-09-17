package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class Inscription {

    private int nas; // nas est le id?
    private Calendar dateInscription;
    private List<Cours> listeCours; // Une liste ou un string?

    public Inscription() {
    }

    public Inscription(int nas, Calendar dateInscription, List<Cours> listeCours) {
        this.nas = nas;
        this.dateInscription = dateInscription;
        this.listeCours = listeCours;
    }
}
