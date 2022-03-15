package com.example.pointini.controllers;

import com.example.pointini.entities.Role;
import com.example.pointini.entities.User;
import com.example.pointini.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserControllers {
    @Autowired
    public UserService userService;

    @GetMapping(path = "/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(path="/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping(path = "/")
    public User createUser(@RequestBody User u) {
        return userService.createUser(u);
    }

    @PutMapping(path="/")
    public User updateUser(@RequestBody User u) {
        return userService.updateUser(u);
    }

    @PostMapping(path="/addRole/{idUser}/{idRole}")
    public  User addRoleUser (@PathVariable Long idUser,@PathVariable Long idRole){
        return userService.addRoleUser(idUser,idRole);
    }



}
