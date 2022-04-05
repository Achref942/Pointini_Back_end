package com.example.pointini.controllers;

import com.example.pointini.entities.Pause;
import com.example.pointini.entities.User;


import com.example.pointini.services.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController

@RequestMapping(path = "/user")
public class UserControllers {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired

    public UserService userService;

    //get all users
    @GetMapping(path = "/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    //find uder by id
    @GetMapping(path = "/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    //create user
    @PostMapping(path = "/")
    public User createUser(@RequestBody User u) {
        String cryptedPassword = bCryptPasswordEncoder.encode(u.getPassword());
        u.setPassword(cryptedPassword);
        return userService.createUser(u);
    }

    //update user
    @PutMapping(path = "/")
    public User updateUser(@RequestBody User u) {
        return userService.updateUser(u);
    }

    //add role to user
    @PostMapping(path = "/addRole/{idUser}/{idRole}")
    public User addRoleUser(@PathVariable Long idUser, @PathVariable Long idRole) {
        return userService.addRoleUser(idUser, idRole);
    }

    // find user by firstname
    @GetMapping(path = "/findByFirstName/{firstName}")
    public ResponseEntity<List<User>> findUserByFirstName(@PathVariable String firstName) {

        List<User> users = userService.findByFirstName(firstName);
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }

    }

    //find user by firstname and lastname
    @GetMapping(path = "/findByFirstNameandLastName/{firstName}/{lastName}")
    public ResponseEntity<List<User>> findByFirstNameandLastName(@PathVariable String firstName, @PathVariable String lastName) {

        List<User> users = userService.findByFirstNameAndLastName(firstName, lastName);
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }

    }


    //find user by email just one user
    @GetMapping(path = "/findByEmail/{email}")
    public User findByEmail(@PathVariable String email) {

        User user = userService.findByEmail(email);
        return user;

    }


    // find by password all the users who have the same password
    @GetMapping(path = "/findByPassword/{password}")
    public ResponseEntity<List<User>> findByPassword(@PathVariable String password) {

        List<User> users = userService.findByPassword(password);
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }

    }


    // just Test
    @GetMapping(path = "/date")
    public void Date() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

    }


    @PostMapping(path = "/Login/{email}/{password}")
    public User Login(@PathVariable String email, @PathVariable String password) {
        User user = userService.findByEmail(email);
        BCryptPasswordEncoder cryptedPassword = new BCryptPasswordEncoder();
        if (cryptedPassword.matches(password, user.getPassword())) {
            System.out.println("Login avec succè");
            return user;
        } else {
            System.out.println("erreur de connection");
            return null;
        }
    }
    @PostMapping(path = "/addEntrepriseUser/{idUser}/{idEntreprise}")
    public User addEntrepriseUser(@PathVariable Long idUser, @PathVariable Long idEntreprise) {
        return userService.addEntrepriseUser(idUser,idEntreprise);
    }







}







