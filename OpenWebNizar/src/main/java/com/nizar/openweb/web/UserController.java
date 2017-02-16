package com.nizar.openweb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nizar.openweb.model.Boat;
import com.nizar.openweb.model.User;
import com.nizar.openweb.service.BoatService;
import com.nizar.openweb.service.SecurityService;
import com.nizar.openweb.service.UserService;
import com.nizar.openweb.validator.UserValidator;

// Controller 
@Controller
public class UserController {
    @Autowired
    private UserService     userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator   userValidator;

    @Autowired
    private BoatService     boatservice;

    // Méthode d'enregistrement utilisateur
    @RequestMapping( value = "/registration", method = RequestMethod.GET )
    public String registration( Model model ) {
        model.addAttribute( "userForm", new User() );

        return "registration";
    }

    // Méthode d'enregistrement du formulaire utilisateur
    @RequestMapping( value = "/registration", method = RequestMethod.POST )
    public String registration( @ModelAttribute( "userForm" ) User userForm, BindingResult bindingResult,
            Model model ) {
        // validation du formulaire
        userValidator.validate( userForm, bindingResult );
        // Si erreur on retourne au formulaire
        if ( bindingResult.hasErrors() ) {
            return "registration";
        }

        userService.save( userForm );

        securityService.autologin( userForm.getUsername(), userForm.getPasswordConfirm() );

        return "redirect:/boat";
    }

    // Méthode de connexion utilisateur
    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login( Model model, String error, String logout ) {
        if ( error != null )
            model.addAttribute( "error", "Votre mot de passe est invalide." );

        if ( logout != null )
            model.addAttribute( "message", "Vous avez été deconnecter avec succès." );

        return "login";
    }

    // Méthode de connexion utilisateur
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public String login( @ModelAttribute( "loginForm" ) User userForm, BindingResult bindingResult,
            Model model ) {
        if ( securityService.findLoggedInUsername() != null )
            securityService.autologin( userForm.getUsername(), userForm.getPasswordConfirm() );

        return "redirect:/boat";
    }

    // Methode d'ajoput d'un bateau
    @RequestMapping( value = { "/boat" }, method = RequestMethod.POST )
    public String addBoat( @ModelAttribute( "boatform" ) Boat boat, BindingResult bindingResult, String boatname,
            Model model ) {
        if ( bindingResult.hasErrors() ) {
            return "boat";
        }
        boat.setBoatname( boatname );
        boatservice.addBoat( boat );

        model.addAttribute( "message", "Bateau ajouté " );
        model.addAttribute( "error", "Bateau ajouté " );

        return "redirect:/boat";

    }

    // Methode d'ajoput d'un bateau
    @RequestMapping( value = { "/boat" }, method = RequestMethod.GET )
    public String addBoat( Model model ) {
        model.addAttribute( "boatform", new Boat() );

        return "boat";

    }

}
