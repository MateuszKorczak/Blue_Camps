package org.niebieskidom.bluecamps.repositories;

import org.niebieskidom.bluecamps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
