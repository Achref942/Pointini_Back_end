package com.example.pointini.services;

import com.example.pointini.repository.FicheDePaieRepository;
import com.example.pointini.services.Interface.FicheDePaieServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FicheDePaieService implements FicheDePaieServiceI {
    @Autowired
    public FicheDePaieRepository ficheDePaieRepository;

//    @Override
//    public (){}
}
