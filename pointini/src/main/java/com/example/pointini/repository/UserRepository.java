package com.example.pointini.repository;

import com.example.pointini.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByRole(String libelle);
 //   public User findByemail(String email);


}
