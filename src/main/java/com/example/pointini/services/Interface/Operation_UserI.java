package com.example.pointini.services.Interface;

import com.example.pointini.entities.Operation_User;
import org.springframework.stereotype.Service;


public interface Operation_UserI {
    Operation_User addOperationUser(Long idOperation, Long idUser);
}
