package com.example.pointini.controllers;

import com.example.pointini.entities.Pause;
import com.example.pointini.entities.Pause_User;
import com.example.pointini.services.Pause_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/addPauseToUser")
public class Pause_UserControllers {

    @Autowired
    public Pause_UserService pause_userService;
    @PostMapping(path = "/{idPause}/{idUser}" )
    public Pause_User addPauseUser(@PathVariable Long idPause, @PathVariable Long idUser){
        return pause_userService.addPause_User(idPause,idUser);
    }
}
