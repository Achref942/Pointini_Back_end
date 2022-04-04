package com.example.pointini.controllers;

import com.example.pointini.entities.Pause;
import com.example.pointini.services.PauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pause")
public class PauseControllers {
    @Autowired
    public PauseService pauseService;

    @PostMapping(path="/")
    public Pause CreatePause(Pause pause){
    return pauseService.createPause(pause);
    }

    @PutMapping(path = "/")
    public Pause UpdatePause(Pause pause){
    return pauseService.updatePause(pause);
    }

    @GetMapping(path = "/")
    public List<Pause> findAllPause(){
        return pauseService.findAllPause();
    }

    @GetMapping(path = "/{id}")
    public Pause findPauseById(@PathVariable Long id){
        return  pauseService.findPauseById(id);
    }

}
