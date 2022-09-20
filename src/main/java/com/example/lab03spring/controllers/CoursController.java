package com.example.lab03spring.controllers;

import com.example.lab03spring.models.Cours;
import com.example.lab03spring.models.Lab03DataContext;
import com.example.lab03spring.models.Panier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CoursController {

    private static final Lab03DataContext dataContext = new Lab03DataContext();

    private Panier getPanier(HttpSession session) {
        /*
         TODO: 9/13/2022 Cette méthode doit retourner le panier stocké dans la variable session
          s'il existe, sinon elle retourne un panier vide.
        */
        try {
            Panier panier;
            if(session.getAttribute("panier") != null){
                panier = (Panier)session.getAttribute("panier");
            }
            else{
                panier = new Panier();
            }
            return panier;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/liste")
    public ModelAndView liste() {
        /*
         TODO: 9/13/2022 Cette méthode doit afficher la vue "ListeCours.jsp" en lui envoyant la
          liste des cours du dataContext. Cette méthode est appelée suite à un clic sur le lien
          "choix de cours".
        */
        try {
            return new ModelAndView("views/listeCours", "cours", dataContext.getListeCours());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/liste/ajouter/{id}")
    public String ajouter(@PathVariable("id") String id, HttpSession session) {
        /*
         TODO: 9/13/2022 Cette méthode est appelée suite à un clic sur le lien "Choisir". Elle
          reçoit le numéro de cours comme paramètre et ajoute le cours qui possède ce numéro au
          panier qui est stocké dans la variable session. Après elle remet le panier dans la
          session pour la prochaine transaction. Elle nous redirige vers la méthode "liste".
        */
        try {
            // recupere le cours passer en parametre
            Cours cours = dataContext.getCours(id);
            // recupere le panier de session
            Panier panier = this.getPanier(session);
            // ajoute le cours au panier
            panier.ajouterCours(cours);
            // remet le panier dans la variable session
            session.setAttribute("panier", panier);
            return "redirect:/liste";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
