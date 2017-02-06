package com.nizar.openweb.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nizar.openweb.model.Role;
import com.nizar.openweb.model.User;
import com.nizar.openweb.repository.UserRepository;

// Implémentation de l'interfac UserDetailService
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    // Methode implémenté par Spring de l'interface UserDetailService pour
    // récupere les informations utilisateurs
    @Override
    @Transactional( readOnly = true )
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User user = userRepository.findByUsername( username );

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for ( Role role : user.getRoles() ) {
            grantedAuthorities.add( new SimpleGrantedAuthority( role.getName() ) );
        }

        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(),
                grantedAuthorities );
    }
}
