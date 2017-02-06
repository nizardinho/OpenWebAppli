package com.nizar.openweb.service;

import com.nizar.openweb.model.User;

// Interface UserService //
public interface UserService {

    // enregistrement d'un utiisateur
    void save( User user );

    // recherhe utilisateur par nom d'utilisateur
    User findByUsername( String username );
}
