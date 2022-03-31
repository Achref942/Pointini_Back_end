package com.example.pointini.services;

import com.example.pointini.entities.Pointage;
import com.example.pointini.entities.User;
import com.example.pointini.repository.PointgeRepository;
import com.example.pointini.services.Interface.PointageServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PointageService implements PointageServiceI {
    @Autowired
    public PointgeRepository pointgeRepository;
    @Autowired
    public UserService userService;

    @Override
    public Pointage findPointageByUserIdAndEtat(Long idUser, int etat) {
        return pointgeRepository.findPointageByUserIdAndEtat(idUser, etat);
    }

    @Override
    public Pointage createPointage(Pointage pointage, Long idUser) {
        User user = userService.findUserById(idUser);
        pointage.setUser(user);
        pointage.setArrive(LocalDateTime.now());
        pointage.setDate(LocalDate.now());
        pointage.setEtat(0);
        return pointgeRepository.save(pointage);
    }

    @Override
    public Pointage updatePointage(Pointage pointage, Long idUser) {
        User user = userService.findUserById(idUser);
        pointage.setUser(user);
        pointage.setSortir(LocalDateTime.now());
        pointage.setEtat(1);
        return pointgeRepository.save(pointage);
    }

    @Override
    public List<Pointage> getAllPointage() {
        return pointgeRepository.findAll();
    }

    @Override
    public Pointage checkPointage(Long idUser) {
        if (pointgeRepository.findPointageByUserIdAndEtat(idUser, 0) != null) {
            Pointage pointage = this.findPointageByUserIdAndEtat(idUser, 0);
            this.updatePointage(pointage, idUser);
            return pointage;
        } else {
            Pointage pointage = new Pointage();
            this.createPointage(pointage, idUser);
            return pointage;
        }
    }

}
