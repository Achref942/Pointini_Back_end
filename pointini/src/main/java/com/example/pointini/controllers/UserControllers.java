package com.example.pointini.controllers;

import com.example.pointini.entities.User;
import com.example.pointini.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserControllers {
    @Autowired
    private UserService userService;
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
        return userService.CreateUser(u);
    }
    @PutMapping(path="/")
    public User updateUser(@RequestBody User u) {
        return userService.updateUser(u);
    }

}
