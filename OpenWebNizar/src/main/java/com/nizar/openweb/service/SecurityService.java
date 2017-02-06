package com.nizar.openweb.service;

//Interface de Security pour la partie enregistrement et verifaction Utilisateur
public interface SecurityService {
    // Recherche d'un utilisateur avec son nom d'utilisateur
    String findLoggedInUsername();

    // Auto connexion utilisateur
    void autologin( String username, String password );
}
