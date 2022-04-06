package com.example.pointini.services;

import com.example.pointini.entities.Enum.TypeOperation;
import com.example.pointini.entities.Operation;
import com.example.pointini.entities.Operation_User;
import com.example.pointini.entities.User;
import com.example.pointini.repository.Operation_UserRepository;
import com.example.pointini.services.Interface.Operation_UserI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Operation_UserService implements Operation_UserI {
    @Autowired
    public OperationService operationService;
    @Autowired
    public Operation_UserRepository operation_userRepository;
    @Autowired
    public UserService userService;

    @Override
    public Operation_User addOperationUser(Long idOperation, Long idUser){
    Operation_User operation_user=new Operation_User();
        Operation operation=operationService.findOperationByid(idOperation);
    User user=userService.findUserById(idUser);
    double s=user.getSalaire();
    if(operation.getTypeOperation()== TypeOperation.penalite ||
            operation.getTypeOperation()== TypeOperation.avance )
    {
        s=s-operation.getMontant();
        user.setSalaire(s);
        userService.updateUser(user);
        operation_user.setUser(user);
        operation_user.setOperation(operation);
        operation_user.setDateOperation(LocalDateTime.now());
        return operation_userRepository.save(operation_user);
    }
    else {
        s=s+operation.getMontant();
        user.setSalaire(s);
        userService.updateUser(user);
        operation_user.setUser(user);
        operation_user.setOperation(operation);
        operation_user.setDateOperation(LocalDateTime.now());
        return operation_userRepository.save(operation_user);
    }
    }
//    @Override
//    public Operation_User addOperationAllUser(Long idOperation){
//        Opera
//
//    }
}
