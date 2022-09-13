package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Panier {

    private static List<Cours> liste = new ArrayList<Cours>();

    public void ajouterCours(Cours cours){
        liste.add(cours);
    }

    public void supprimerCours(String numero){
        liste.removeIf(n -> Objects.equals(n.getNumero(), numero));
    }

    public void viderPanier(){
        liste.clear();
    }
}
