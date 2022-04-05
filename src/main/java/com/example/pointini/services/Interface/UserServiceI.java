package com.example.pointini.services.Interface;

import com.example.pointini.entities.Pause;
import com.example.pointini.entities.Pointage;
import com.example.pointini.entities.User;

import java.util.List;

public interface UserServiceI  {
    List<User> getAllUser();

    User findUserById(Long id);

    User createUser(User u);

    User updateUser(User u);

    List<User> findByRole(String libelle);

    User  addRoleUser (Long idUser,Long idRole);

    List<User>  findByFirstName(String firstName);

    List<User> findByFirstNameAndLastName(String firstName,String lastName);

    User findByEmail(String email);

    List<User> findByPassword(String password);

    User addEntrepriseUser(Long idUser, Long idEntreprise);

   // Pause AddPauseUser(Long idPause, Long idUser);


    //    @Override
    //    public void delete(Long id) {
    //        userRepository.deleteById(id);
    //    }

    // void delete(Long id);
}
