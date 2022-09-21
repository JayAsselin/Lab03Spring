package com.example.lab03spring.controllers;

import com.example.lab03spring.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdminController {

    // TODO: 9/13/2022 Optional controller to manage the web app
    private static final Lab03DataContext dataContext = new Lab03DataContext();
    private Admin adminSession;

    /**
     * Creer un objet session pour Admin
     * @param session
     * @return
     */
    private Admin loginSession(HttpSession session){
        try {
            if(session.getAttribute("admin")!=null){
                adminSession = (Admin) session.getAttribute("admin");
            }
            else {
                session.setAttribute("admin", null);
            }
            return adminSession;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Affiche la vue de connection admin et verifie si il y en a deja un dans la session pour
     * les redirection
     * @param model
     * @param session
     * @param request
     * @return
     */
    @GetMapping("/login")
    public ModelAndView adminLogin(Model model, HttpSession session, HttpServletRequest request){
        try {
            model.addAttribute("login", new Admin());
            if (loginSession(session) != null){
                adminSession = loginSession(session);
                return new ModelAndView("views/adminPanel");
            }
            session.setAttribute("admin", new Admin());
            return new ModelAndView("views/adminLogin");
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }


    /**
     * Methode post pour connecter l'administrateur au tableau de bord
     * @param admin
     * @param result
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ModelAndView adminLogin(@Valid @ModelAttribute("login") Admin admin,
                                   BindingResult result, HttpServletRequest request){
        try {
            if (result.hasErrors()){
                return new ModelAndView("views/adminLogin");
            }
            return new ModelAndView("views/adminPanel");
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }


    /**
     * Affiche le formulaire d'ajout de cours
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/login/adminPanel/addCours")
    public ModelAndView adminPanelAddCours(Model model, HttpServletRequest request){
        try {
            model.addAttribute("newCours", new Cours());
            return new ModelAndView("views/addCours");
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }

    /**
     * Envoie le formulaire et ajoute un cours a la liste addCours
     * @param cours
     * @param result
     * @param request
     * @return
     */
    @PostMapping("/login/adminPanel/addCours")
    public ModelAndView adminPanelAddCours(@Valid @ModelAttribute("newCours") Cours cours,
                                     BindingResult result, HttpServletRequest request){
        try {
            if (result.hasErrors()){
                return new ModelAndView("views/addCours");
            }
            dataContext.addCours(cours);
            return new ModelAndView("views/adminPanel");
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }

    /**
     * Affiche la vue ajouter etudiant
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/login/adminPanel/addEtudiant")
    public ModelAndView adminPanelAddEtudiant(Model model, HttpServletRequest request){
        try {
            model.addAttribute("newEtudiant", new Etudiant());
            return new ModelAndView("views/addEtudiant");
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }

    /**
     * Envoie le formaulaire et ajoute un etudiant a la liste addEtudiant
     * @param etudiant
     * @param result
     * @param request
     * @return
     */
    @PostMapping("/login/adminPanel/addEtudiant")
    public ModelAndView adminPanelAddEtudiant(@Valid @ModelAttribute("newEtudiant") Etudiant etudiant,
                                        BindingResult result, HttpServletRequest request){
        try {
            if (result.hasErrors()){
                return new ModelAndView("views/addEtudiant");
            }
            dataContext.addEtudiant(etudiant);
            return new ModelAndView("views/adminPanel");
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }

    /**
     * Enleve l'attribue de session et redirige vers la vue de connection administrateur
     * @param session
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest request){
        try {
            if (session.getAttribute("admin") != null) {
                session.removeAttribute("admin");
            }
            return new ModelAndView("redirect:/login");
        } catch (Exception e) {
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }
}
