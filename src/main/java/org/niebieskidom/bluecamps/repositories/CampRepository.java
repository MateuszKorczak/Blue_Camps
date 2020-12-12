package org.niebieskidom.bluecamps.repositories;

import org.niebieskidom.bluecamps.entity.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CampRepository extends JpaRepository<Camp, Long> {
    void deleteById(Optional<Camp> id);


    @Query("SELECT c FROM Camp c WHERE c.startDate BETWEEN :first AND :second ORDER BY c.startDate")
    List<Camp> findCampByStartDateEqualsCurrentYear(@Param("first") java.util.Date first, @Param("second") java.util.Date second);



}
