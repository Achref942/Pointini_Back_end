package com.example.pointini.services;

import com.example.pointini.entities.Operation;
import com.example.pointini.repository.OperationRepository;
import com.example.pointini.services.Interface.OperationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService  implements OperationServiceI {
    @Autowired
    public OperationRepository operationRepository;

    @Override
    public Operation CreateOperation(Operation operation){
        return operationRepository.save(operation);
    }
    @Override
    public Operation UpdateOperation (Operation operation){
        return operationRepository.save(operation);
    }
    @Override
    public Operation findOperationByid(Long id){
        return operationRepository.findById(id).get();
    }


}
