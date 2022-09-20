package com.example.lab03spring.controllers;

import com.example.lab03spring.models.ErrorModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @GetMapping("/session/info")
    public ModelAndView infoSession(HttpSession session, HttpServletRequest request) {
        try {
            int x = 1/0;
            // placer des donner dans la session
            String name = "Jerome";
            session.setAttribute("name", name);
            return new ModelAndView("views/info");
        } catch (Exception e) {
//            ErrorModel model = new ErrorModel();
//            model.setCode(e.hashCode());
//            model.setMessage(e.getMessage());
//            return new ModelAndView("error", "model", model);
            ModelAndView view = new ModelAndView("error");
            // initialiser le model à envoyer à la vue erreur
            ErrorModel viewModel = new ErrorModel(request.getRequestURL().toString(), e);
            // envoyer le model à la vue erreur
            view.addObject("model",viewModel );
            return view;
        }
    }


}
