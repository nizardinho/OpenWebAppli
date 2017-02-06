package com.nizar.openweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nizar.openweb.model.Boat;

// Interface JPA (DAO) pour l'entité Boat//

public interface BoatRepository extends JpaRepository<Boat, Long> {

}
