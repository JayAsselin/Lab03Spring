package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Panier {

    public List<Cours> getListe() {
        return liste;
    }

    private final List<Cours> liste;

    public Panier() {
        this.liste = new ArrayList<Cours>();
    }

    public void ajouterCours(Cours cours){
        liste.add(cours);
    }

    public void supprimerCours(String numero){
        liste.removeIf(n -> n.getNumero().equals(numero));
    }

    public void viderPanier(){
        liste.clear();
    }
}
