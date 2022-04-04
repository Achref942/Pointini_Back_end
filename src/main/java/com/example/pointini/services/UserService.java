package com.example.pointini.services;

import com.example.pointini.entities.Entreprise;
import com.example.pointini.entities.Pause;
import com.example.pointini.entities.Role;
import com.example.pointini.entities.User;
import com.example.pointini.repository.PauseRepository;
import com.example.pointini.repository.UserRepository;
import com.example.pointini.services.Interface.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceI {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoleService roleService;

    @Autowired
    public EntrepriseService entrepriseService;


    @Autowired
    public PauseRepository pauseRepository;

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User u) {

        return userRepository.save(u);
    }

    @Override
    public User updateUser(User u) {
        return userRepository.save(u);

    }

    @Override
    public List<User> findByRole(String libelle) {
        return userRepository.findByRole(libelle);
    }

    @Override
    public User addRoleUser(Long idUser, Long idRole) {
        User user = this.findUserById(idUser);
        Role role = this.roleService.findRoleById(idRole);
        user.setRole(role);
        return this.updateUser(user);

    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    @Override
    public User addEntrepriseUser(Long idUser, Long idEntreprise){
        User user=this.findUserById(idUser);
        Entreprise entreprise=entrepriseService.findEntrepriseById(idEntreprise);
        user.setEntreprise(entreprise);
        return this.updateUser(user);
    }

    @Override
    public Pause AddPauseUser (Long idPause,Long idUser){
        User user=this.findUserById(idUser);
        Pause pause=pauseRepository.getById(idPause);
        user.getPauses().add(pause);
        return pauseRepository.save(pause);
    }



}
