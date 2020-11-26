package org.niebieskidom.bluecamps.services;

import org.niebieskidom.bluecamps.repositories.CampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampService {
    @Autowired
    private final CampRepository campRepository;

    public CampService(CampRepository campRepository) {
        this.campRepository = campRepository;
    }
}
