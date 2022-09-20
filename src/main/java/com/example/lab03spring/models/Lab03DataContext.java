package com.example.lab03spring.models;


import java.util.ArrayList;
import java.util.List;

public class Lab03DataContext {

    private static final List<Cours> listeCours = new ArrayList<Cours>() {
        {
            add(new Cours("BEXADZAL076", "Microsoft Office", 45, 4, "office.pdf"));
            add(new Cours("APOPDOS1", "Fondamentaux de l'informatique", 59, 3,
                    "fondamentaux" + ".pdf"));
            add(new Cours("FCTATTP1", "Conception web", 5, 1, "web.pdf"));
            add(new Cours("EBVIVNVXHNO", "Cours de pointage", 41, 4, "pointage.pdf"));
            add(new Cours("BLFLLI2X225", "Animations 3D", 83, 2, "animation.pdf"));
            add(new Cours("ARABPS22100", "Génie logiciel", 53, 4, "genie.html"));
            add(new Cours("SMMIGMG1", "Le marketing numérique", 37, 3, "marketing.pdf"));
            add(new Cours("CITIVECA", "Cours de matériel informatique", 30, 4, "informatique.pdf"));
            add(new Cours("BHELSHJJ", "Cours de comptabilité", 29, 3,
                    "comptabilite" + ".pdf"));
            add(new Cours("TARATZTZ", "La cyber-sécurité", 78, 2, "cyber-sec.pdf"));
            add(new Cours("FIHTIMD1", "Conception graphique", 63, 1, "conception.pdf"));
            add(new Cours("BDAFGPGX", "Cours Python", 95, 2, "python.pdf"));
            add(new Cours("NSOBEGC1", "Animation et VFX", 88, 2, "VFX.pdf"));
        }
    };

    private static final List<Etudiant> listeEtudiants = new ArrayList<Etudiant>() {
        {
            add(new Etudiant(829392, "Haley", "Argine", "(791) 297-1035", "1343 Kendra " +
                    "Trafficway", "J0R M4K", "Argine_Haley@gmail.com", 'F'));
            add(new Etudiant(820814, "Kub", "Léon", "(318) 654-8267", "6480 Keyshawn Loaf", "G3K V9T"
                    , "Noe_Kub8@yahoo.com", 'M'));
            add(new Etudiant(898468, "Grady", "Coline", "(366) 285-3468", "86843 Schoen Parkway",
                    "K4K K1B", "Coline66@yahoo.com", 'F'));
            add(new Etudiant(678714, "Ernser", "Sophie", "(736) 697-6152", "159 Kunde Throughway"
                    , "V7T J5Z", "Sophie.Ernser58@gmail.com", 'F'));
            add(new Etudiant(671982, "Towne", "Martial", "(241) 978-2686", "46723 Ratke Vista",
                    "B3H L3B", "Martial.Towne@yahoo.com", 'M'));
        }
    };

    private static final List<Inscription> listeInscription = new ArrayList<Inscription>();

    public static void inscrire(Inscription element) {
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

    public static Cours getCours(String id) {
        Cours cours;
        cours = listeCours.stream().filter(c -> c.getNumero().equals(id)).findFirst().get();
        return cours;
    }
}
