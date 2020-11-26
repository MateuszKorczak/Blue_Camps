package org.niebieskidom.bluecamps.repositories;

import org.niebieskidom.bluecamps.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
