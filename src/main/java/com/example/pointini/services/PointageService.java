package com.example.pointini.services;

import com.example.pointini.entities.Pointage;
import com.example.pointini.entities.User;
import com.example.pointini.repository.PointgeRepository;
import com.example.pointini.services.Interface.PointageServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointageService implements PointageServiceI {
    @Autowired
    public PointgeRepository pointgeRepository ;
    @Autowired
    public UserService userService ;
    @Override
    public Pointage createPointage(Pointage pointage ,Long idUser) {
        User user=userService.findUserById(idUser);
     pointgeRepository.save(pointage);
     pointage.setUser(user);
     pointage.setEtat(false);
        return pointgeRepository.save(pointage);
    }

    @Override
    public Pointage findPointageByUserId(Long idUser) {
        return pointgeRepository.findPointageByUserId(idUser);
    }


    @Override
    public Pointage updatePointage(Pointage pointage ,Long idUser) {
        User user=userService.findUserById(idUser);
        pointgeRepository.save(pointage);
        pointage.setUser(user);
        pointage.setEtat(true);
        return pointgeRepository.save(pointage);

    }
    @Override
    public Pointage findPointageById(Long id) {
        return pointgeRepository.findById(id).get();

    }
    @Override
    public List<Pointage> getAllPointage() {

        return pointgeRepository.findAll();
    }
    @Override
    public Pointage checkPointage(Long idUser){

        if(pointgeRepository.CheckEtatByUserId(idUser)){
            Pointage pointage=this.findPointageByUserId(idUser);
            this.updatePointage(pointage,idUser);
            return pointage;
        }
        else{
            Pointage pointage=new Pointage();
            this.createPointage(pointage,idUser);
            return pointage;
        }

    }
   }
