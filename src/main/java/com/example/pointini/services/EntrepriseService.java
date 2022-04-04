package com.example.pointini.services;

import com.example.pointini.entities.Entreprise;
import com.example.pointini.entities.Pack;
import com.example.pointini.repository.EntrepriseRepository;
import com.example.pointini.repository.PackRepository;
import com.example.pointini.services.Interface.EntrepriseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntrepriseService implements EntrepriseServiceI {
 @Autowired
    public EntrepriseRepository entrepriseRepository;

    @Autowired
    public PackRepository packRepository;
    @Override
    public List<Entreprise> getAllEntreprise() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise findEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).get();

    }
    @Override
    public Entreprise createEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }


    @Override
    public Pack AddPackToEntreprise(Long idPack, Long idEntreprise) {
        Entreprise entreprise = this.findEntrepriseById(idEntreprise);
        Pack pack = packRepository.findPackById(idPack);
        entreprise.setExpirationPack(pack.getExpiration());
        entreprise.getPack().add(pack);

        return packRepository.save(pack);
    }
}
