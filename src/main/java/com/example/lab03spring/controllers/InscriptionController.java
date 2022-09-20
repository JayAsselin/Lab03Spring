package com.example.lab03spring.controllers;

import com.example.lab03spring.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class InscriptionController {

    private static final Lab03DataContext dataContext = new Lab03DataContext();

    private Panier getPanier(HttpSession session) {
        /*
         TODO: 9/13/2022 Cette méthode doit retourner le panier stocké dans la variable session
          s'il existe, sinon elle retourne un panier vide.
        */
        Panier panier;
        if(session.getAttribute("panier") != null){
            panier = (Panier)session.getAttribute("panier");
        }
        else{
            panier = new Panier();
        }
        return panier;
    }

    @GetMapping("/panier")
    public ModelAndView afficher() {
        /*
         TODO: 9/13/2022 Cette méthode est appelée suite à un clic sur le lien "Voir mes choix".
          Cette méthode affiche la vue "AfficherPanier.jsp" en lui envoyant le panier qui se
          trouve dans la variable session.
        */
        return new ModelAndView("views/afficherPanier");
    }

    @GetMapping("viderPanier")
    public String viderPanier(HttpSession session) {
        Panier panier = this.getPanier(session);
        panier.viderPanier();
        return "redirect:/liste";
    }

    @GetMapping("/panier/supprimer/{id}")
    public String supprimer(@PathVariable("id") String id, HttpSession session) {
        /*
         TODO: 9/13/2022 Cette méthode répond à un clic sur le lien "Supprimer". Elle reçoit le
          numéro de cours comme paramètre et supprime le cours qui possède ce numéro du panier
          qui se trouve dans la variable session. Après elle remet le panier dans la session
          pour la prochaine transaction. Cette méthode nous redirige vers la méthode "afficher".
        */
        // recupere le panier de la variable session
        Panier panier = this.getPanier(session);
        panier.supprimerCours(id);
        // renvoie le panier dans la variable session
        session.setAttribute("panier", panier);
        return "redirect:/panier";
    }

    @GetMapping("/validation")
    public ModelAndView valider() {
        /*
         TODO: 9/13/2022 Cette méthode répond à un clic sur le lien "Valider mes choix".
          Elle affiche la vue nommée "ValiderEtudiant.jsp" en lui envoyant la liste des
          étudiants pour que l'utilisateur confirme son numéro d'étudiant.
        */

        return new ModelAndView("views/validerEtudiant", "etudiants",
                dataContext.getListeEtudiants());
    }

    @GetMapping("/confirmation/{id}")
    public ModelAndView confirmer(@PathVariable("id") int id, HttpSession session) {
        /*
         TODO: 9/13/2022 Cette méthode répond à un clic sur le lien confirmer qui correspond à
          l'étudiant choisi de la liste. Cette méthode crée une inscription pour cette étudiant
          et l'insert dans la liste des inscriptions "listeInscriptions" du dataContext. Elle
          affiche la vue "Confirmation.jsp".
        */
        Etudiant etudiant =
                dataContext.getListeEtudiants().stream().filter(e->e.getNas() == id).findFirst().get();
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        Panier panier = this.getPanier(session);
        Inscription inscription = new Inscription(etudiant.getNas(), cal, panier.getListe());
        dataContext.inscrire(inscription);
        return new ModelAndView("views/confirmation");
    }
}
