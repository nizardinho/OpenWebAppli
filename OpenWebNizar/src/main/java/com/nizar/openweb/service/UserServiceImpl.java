package com.nizar.openweb.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nizar.openweb.model.User;
import com.nizar.openweb.repository.RoleRepository;
import com.nizar.openweb.repository.UserRepository;

//Implémentation Interface UserService //
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository        userRepository;
    @Autowired
    private RoleRepository        roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // enregistrement d'un utiisateur
    @Override
    public void save( User user ) {
        user.setPassword( bCryptPasswordEncoder.encode( user.getPassword() ) );
        user.setRoles( new HashSet<>( roleRepository.findAll() ) );
        userRepository.save( user );
    }

    // recherhe utilisateur par nom d'utilisateur
    @Override
    public User findByUsername( String username ) {
        return userRepository.findByUsername( username );
    }

}
