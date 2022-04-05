package com.example.pointini.services.Interface;

import com.example.pointini.entities.Operation;

public interface OperationServiceI {
    Operation CreateOperation(Operation operation);

    Operation UpdateOperation(Operation operation);

    Operation findOperationByid(Long id);
}
