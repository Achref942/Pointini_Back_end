package com.example.pointini.services.Interface;

import com.example.pointini.entities.Pause;

import java.util.List;

public interface PauseServiceI {
    Pause createPause(Pause pause);

    Pause updatePause(Pause pause);

    List<Pause> findAllPause();

    Pause findPauseById(Long id);
}
