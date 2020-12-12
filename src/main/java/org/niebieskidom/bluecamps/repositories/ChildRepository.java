package org.niebieskidom.bluecamps.repositories;

import org.niebieskidom.bluecamps.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query(value = "SELECT * FROM children JOIN user_child ON children.id = user_child.child_id WHERE user_id=?1", nativeQuery = true)
    List<Child> findChildrenByUserId(Long id);
}
