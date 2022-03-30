package com.example.pointini.repository;

import com.example.pointini.entities.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PointgeRepository extends JpaRepository<Pointage, Long> {

    @Query("SELECT p FROM Pointage p WHERE p.etat =0 ")
    Pointage findPointageByUserId(Long idUser);

//    Long CheckedPointageByUserId(@Param("user") Long id);
  Pointage findPointageById (Long id);

}
