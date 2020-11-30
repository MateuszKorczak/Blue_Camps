package org.niebieskidom.bluecamps.services;

import org.niebieskidom.bluecamps.entity.Camp;
import org.niebieskidom.bluecamps.repositories.CampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampService {
    @Autowired
    private final CampRepository campRepository;

    public CampService(CampRepository campRepository) {
        this.campRepository = campRepository;
    }


    public List<Camp> showCamps(){
        return campRepository.findAll();
    }

    public Optional<Camp> getCamp(Long id){
        Optional<Camp> optionalCamp = campRepository.findById(id);
        return optionalCamp;
    }

    public void addCamp(Camp camp){
        campRepository.save(camp);
    }

    public void deleteCamp(Long id){
        campRepository.deleteById(id);
    }

    public void updateCamp(Camp camp){
        campRepository.save(camp);
    }

}
