package com.nizar.openweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nizar.openweb.model.User;

//Interface JPA (DAO) pour l'entité User //

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}
