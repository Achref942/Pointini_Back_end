package com.example.pointini.services;

import com.example.pointini.entities.User;

import java.util.List;

public interface UserServiceI {
    List<User> getAllUser();

    User findUserById(Long id);

    User CreateUser(User u);

    User updateUser(User u);

    List<User> findByRole(String libelle);


    //    @Override
    //    public void delete(Long id) {
    //        userRepository.deleteById(id);
    //    }

    // void delete(Long id);
}
