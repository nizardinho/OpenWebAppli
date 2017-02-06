package com.nizar.openweb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nizar.openweb.model.User;
import com.nizar.openweb.service.UserService;

// Classe UserValidator implémentant l'interfac Validator afin de valider le form d'enregistrement
@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    // Cette méthode de l'interface Validator, valide les instance d'une classe
    // fournie
    @Override
    public boolean supports( Class<?> aClass ) {
        return User.class.equals( aClass );
    }

    // Valide ou envoi un message d'erreur pour le formulaire d'enregistement (
    // Fichier src/main/resources/message.properties utilisé pour configurer les
    // messages à afficher à l'utilisateur
    @Override
    public void validate( Object o, Errors errors ) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "username", "NotEmpty" );
        if ( user.getUsername().length() < 3 || user.getUsername().length() > 32 ) {
            errors.rejectValue( "username", "Size.userForm.username" );
        }
        if ( userService.findByUsername( user.getUsername() ) != null ) {
            errors.rejectValue( "username", "Duplicate.userForm.username" );
        }

        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password", "NotEmpty" );
        if ( user.getPassword().length() < 3 || user.getPassword().length() > 32 ) {
            errors.rejectValue( "password", "Size.userForm.password" );
        }

        if ( !user.getPasswordConfirm().equals( user.getPassword() ) ) {
            errors.rejectValue( "passwordConfirm", "Diff.userForm.passwordConfirm" );
        }
    }

}
