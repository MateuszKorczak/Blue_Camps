package org.niebieskidom.bluecamps.repositories;

import org.niebieskidom.bluecamps.entity.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampRepository extends JpaRepository<Camp, Long> {
    void deleteById(Optional<Camp> id);
}
