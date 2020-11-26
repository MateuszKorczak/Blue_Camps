package org.niebieskidom.bluecamps.services;

import org.niebieskidom.bluecamps.repositories.ChildRepository;
import org.springframework.stereotype.Service;

@Service
public class ChildService {
    private final ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }
}
