package com.example.pointini.controllers;

import com.example.pointini.entities.User;
import com.example.pointini.entities.UserLogin;
import com.example.pointini.requests.FirstNameAndLastNameRequest;
import com.example.pointini.services.UserLoginService;
import com.example.pointini.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@RestController

@RequestMapping(path="/user")
public class UserControllers {
    @Autowired
    public UserService userService;
    @Autowired
    public UserLoginService Login ;

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
    @GetMapping(path="/findByFirstName/{firstName}")
    public ResponseEntity<List<User>> findUserByFirstName(@PathVariable String firstName) {

        List<User> users = userService.findByFirstName(firstName);
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
        }

    }
    @GetMapping(path="/findByFirstNameandLastName/{firstName}/{lastName}")
    public ResponseEntity<List<User>> findByFirstNameandLastName(@PathVariable String firstName,@PathVariable String lastName) {

        List<User> users = userService.findByFirstNameAndLastName(firstName,lastName);
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
        }

    }
    @GetMapping(path="/findByFirstNameandLastNameWithRB")
    public ResponseEntity<List<User>> findByFirstNameandLastNameWithRB(@RequestBody FirstNameAndLastNameRequest firstNameAndLastNameRequest) {

        List<User> users = userService.findByFirstNameAndLastName(firstNameAndLastNameRequest.getFirstName(),firstNameAndLastNameRequest.getLastName());
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
        }

    }


    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new UserLogin());
        return mav;
    }


    @PostMapping("/login/{email}/{password}")
    public  String login(@PathVariable String email, @PathVariable String password ) {
        UserLogin userLogin = Login.login(email,password);

        System.out.print(userLogin);
        if(Objects.nonNull(userLogin))
        {

            return "mt3aditch";


        } else {
            return  "T3zdit";


        }

    }







    }