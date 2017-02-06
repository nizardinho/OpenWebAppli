package com.nizar.openweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nizar.openweb.model.Role;

// Interface JPA (DAO) pour l'entité Role //

public interface RoleRepository extends JpaRepository<Role, Long> {
}
