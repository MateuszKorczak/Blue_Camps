package org.niebieskidom.bluecamps.repositories;

import org.niebieskidom.bluecamps.entity.Camp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampRepository extends JpaRepository<Camp, Long> {
}
