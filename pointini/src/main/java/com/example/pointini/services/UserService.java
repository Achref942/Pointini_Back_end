package com.example.pointini.services;

import com.example.pointini.entities.User;
import com.example.pointini.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceI {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> utOptional=userRepository.findById(id);
        if(utOptional==null) {
            return null;
        }else {
            return utOptional.get();
        }

    }

    @Override
    public User CreateUser(User u) {

        return userRepository.save(u);
    }

    @Override
    public User updateUser(User u) {
        return userRepository.save(u);

    }
    @Override
    public List<User> findByRole(String libelle) {
        return userRepository.findByRole(libelle);
    }




//    @Override
//    public void delete(Long id) {
//        userRepository.deleteById(id);
//    }



}
