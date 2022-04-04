package com.example.pointini.services;

import com.example.pointini.entities.Pause;
import com.example.pointini.repository.PauseRepository;
import com.example.pointini.services.Interface.PauseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PauseService implements PauseServiceI {
    @Autowired
    public PauseRepository pauseRepository;

    @Override
    public Pause createPause(Pause pause){
      return  pauseRepository.save(pause);
    }

    @Override
    public Pause updatePause(Pause pause){
        return pauseRepository.save(pause);
    }

    @Override
    public List<Pause> findAllPause(){
        return pauseRepository.findAll();
    }
    @Override
    public Pause findPauseById(Long id) {
        return pauseRepository.findById(id).get();

    }

}
