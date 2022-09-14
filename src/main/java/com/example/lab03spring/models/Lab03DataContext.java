package com.example.lab03spring.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lab03DataContext {

    private static List<Cours> listeCours = new ArrayList<Cours>() {
        {
            add(new Cours("Prog101", "Programmation", 15, 2, "ProgPC"));
            add(new Cours("Adm23", "Administration", 8, 4, "AdminPC"));
            add(new Cours("Pho99", "Photographie", 25, 1, "PhotoPC"));
        }
    };

    private static List<Etudiant> listeEtudiants = new ArrayList<Etudiant>() {
        {
            add(new Etudiant(123456, "Asselin", "Jerome", "(819) 233-2929", "23 Davidson", "J8R " +
                    "2L9", "jay@gmail.com", 'M'));
            add(new Etudiant(723882, "Brisson", "Lisa", "(819) 233-9233", "23" + " Davidson",
                    "J8R 2L9", "lisa@gmail.com", 'F'));
            add(new Etudiant(920034, "Courcy", "Dominic", "(514) 823-9921", "837 Laurier", "J8Z " +
                    "2O5", "do@hotmail" + ".com", 'M'));
        }
    };

    private static List<Inscription> listeInscription = new ArrayList<Inscription>();

    public void inscrire(Inscription element) {
        listeInscription.add(element);
    }

    public static List<Cours> getListeCours() {
        return listeCours;
    }

    public static List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public static List<Inscription> getListeInscription() {
        return listeInscription;
    }

    public static Cours getCours(String numero) {
        Cours cours;
        cours = listeCours.stream().filter(c -> Objects.equals(c.getNumero(), numero)).findFirst().get();
        return cours;
    }
}
