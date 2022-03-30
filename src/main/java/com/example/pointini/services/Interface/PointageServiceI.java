package com.example.pointini.services.Interface;

import com.example.pointini.entities.Pointage;


import java.util.List;

public interface PointageServiceI {
    Pointage createPointage(Pointage pointage, Long id);

    Pointage findPointageByUserIdAndEtat(Long idUser,int etat);


    Pointage updatePointage(Pointage pointage, Long id);

    List<Pointage> getAllPointage();

    Pointage checkPointage(Long idUser);

}
