package com.example.pointini.controllers;

import com.example.pointini.entities.Pointage;
import com.example.pointini.entities.User;
import com.example.pointini.services.PointageService;
import com.example.pointini.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/Pointage")
public class PointageControllers {
    @Autowired
    public PointageService pointageService;
    @Autowired
    public UserService userService;

    //get all users
    @GetMapping(path = "/")
    public List<Pointage> getAllPointage() {
        return pointageService.getAllPointage();
    }

    @GetMapping(path = "/createPointage/{idUser}")
    public Pointage createPointage(@RequestBody Pointage pointage, @PathVariable Long idUser) {

        return pointageService.createPointage(pointage, idUser);
    }

    @PutMapping(path = "/update/{idUser}")
    public Pointage updatePointage(@RequestBody Pointage pointage, @PathVariable Long idUser) {
        return pointageService.updatePointage(pointage, idUser);
    }


    @GetMapping(path = "/checkPointage/{idUser}")
    public Pointage checkPointage(@PathVariable Long idUser) {
        System.out.println(idUser);
        return pointageService.checkPointage(idUser);
    }

    @GetMapping(path = "/find/{idUser}")
    Pointage findPointageByUserId(@PathVariable Long idUser) {
        return pointageService.findPointageByUserIdAndEtat(idUser, 0);
    }
}
