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

//    //create Pointage entree
//    @PostMapping(path = "/createPointageIN")
//    public Pointage createPointageIN(@RequestBody Pointage pointage) {
//       pointage.setArrive(LocalDateTime.now());
//       pointage.setDate(LocalDate.now());
//        return pointageService.createPointage(pointage);
//    }
//
//
//    //create Pointage sortie
//    @PostMapping(path = "/createPointageOUt/{id}")
//    public Pointage createPointageOUt(@PathVariable Long id) {
//        Pointage pointage=pointageService.findPointageById(id);
//        pointage.setSortir(LocalDateTime.now());
//        return pointageService.updatePointage(pointage);
//    }
@PostMapping(path = "/{id}")
public Pointage createPointage(@RequestBody Pointage pointage ,@PathVariable Long idUser) {
    return pointageService.createPointage(pointage,idUser);
}
    @PutMapping(path = "/{id}")
    public Pointage updatePointage(@RequestBody Pointage pointage ,@PathVariable Long idUser) {
        return pointageService.updatePointage(pointage,idUser);
    }

    @GetMapping(path = "/{id}")
    public Pointage findPointageById(@PathVariable Long id) {
        return pointageService.findPointageById(id);
    }
//    @PostMapping(path = "/addPointageUser/{idUser}/{idPointage}")
//    public Pointage addPointageUser(@PathVariable Pointage pointage, @PathVariable Long id) {
//        return  pointageService.createPointage(pointage,id);
//    }
/*@GetMapping(path = "/CheckEtatByUserId/{id}")
    public boolean CheckEtatByUserId(@PathVariable Long id) {
    return pointageService.CheckEtatByUserId(id);
}*/
@GetMapping(path ="/pointage/{idUser}")
    public Pointage checkPointage(@PathVariable Long idUser)
{
    return  pointageService.checkPointage(idUser);
}
}
