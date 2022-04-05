package com.example.pointini.controllers;

import com.example.pointini.entities.Operation;
import com.example.pointini.services.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/operation")
public class OperationControllers {
    @Autowired
    public OperationService operationService;
    @PostMapping(path = "/")
    public Operation CreatOperation(@RequestBody  Operation operation){
        return  operationService.CreateOperation(operation);
    }
    @PutMapping(path = "/")
    public Operation UpdateOperation(@RequestBody  Operation operation){
        return  operationService.UpdateOperation(operation);
    }


}
