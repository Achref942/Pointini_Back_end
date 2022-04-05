package com.example.pointini.controllers;

import com.example.pointini.entities.Operation_User;
import com.example.pointini.services.Operation_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/operationUser")
public class Operation_UserControllers {
    @Autowired
    public Operation_UserService operation_userService;

    @PostMapping(path = "/{idOperation}/{idUser}")
    public Operation_User addOperationToUser(@PathVariable Long idOperation, @PathVariable Long idUser){
        return operation_userService.addOperationUser(idOperation,idUser);
    }

}
