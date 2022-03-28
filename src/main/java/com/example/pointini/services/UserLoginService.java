//package com.example.pointini.services;
//
//import com.example.pointini.entities.UserLogin;
//import com.example.pointini.repository.UserLoginRepository;
//import com.example.pointini.services.Interface.UserLoginI;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserLoginService implements UserLoginI {
//    @Autowired
//    private UserLoginRepository repo;
//
//    public UserLogin login(String email,String password) {
//        UserLogin user = repo.findByUsernameAndPassword(email, password);
//        return user;
//    }
//
//}