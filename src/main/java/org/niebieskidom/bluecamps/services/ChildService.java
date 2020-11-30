package org.niebieskidom.bluecamps.services;

import org.niebieskidom.bluecamps.entity.Child;
import org.niebieskidom.bluecamps.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {
    @Autowired
    private final ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public List<Child> getChildren(){
        return childRepository.findAll();
    }

    public Optional<Child> getChild(Long id){
        Optional<Child> optionalChild= childRepository.findById(id);
        return optionalChild;
    }

    public void addChild(Child child){
        childRepository.save(child);
    }

    public void deleteChild(Long id){
        childRepository.deleteById(id);
    }

    public void updateChild(Child child){
        childRepository.save(child);
    }

}
