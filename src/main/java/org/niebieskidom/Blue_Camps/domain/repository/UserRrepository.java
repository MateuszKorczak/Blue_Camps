package org.niebieskidom.Blue_Camps.domain.repository;

import org.niebieskidom.Blue_Camps.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRrepository extends JpaRepository<User,Long> {
}
