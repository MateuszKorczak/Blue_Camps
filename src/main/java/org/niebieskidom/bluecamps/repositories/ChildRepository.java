package org.niebieskidom.bluecamps.repositories;

import org.niebieskidom.bluecamps.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

}
