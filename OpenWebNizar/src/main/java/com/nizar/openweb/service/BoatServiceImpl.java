package com.nizar.openweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nizar.openweb.model.Boat;
import com.nizar.openweb.repository.BoatRepository;

// Implementation interface ServiceBoat
@Service
public class BoatServiceImpl implements BoatService {

    @Autowired
    private BoatRepository boatRepository;

    // Implementation méthode
    @Override
    public void addBoat( Boat boat ) {

        boatRepository.save( boat );

    }

}
