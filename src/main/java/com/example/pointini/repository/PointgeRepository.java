package com.example.pointini.repository;

import com.example.pointini.entities.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PointgeRepository extends JpaRepository<Pointage, Long> {
    @Query("SELECT p.etat FROM Pointage p WHERE p.etat =false AND p.user=:user")
    boolean CheckEtatByUserId(@Param("user") Long id);
    Pointage findPointageByUserId(Long idUser);
}
