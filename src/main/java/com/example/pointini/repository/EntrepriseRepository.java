package com.example.pointini.repository;

import com.example.pointini.entities.Entreprise;
import com.example.pointini.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
