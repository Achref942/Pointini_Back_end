package com.example.pointini.repository;

import com.example.pointini.entities.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointgeRepository extends JpaRepository<Pointage, Long> {

    Pointage findPointageByUserIdAndEtat(Long user,int etat);

}
