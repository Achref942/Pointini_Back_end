package com.example.pointini.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation_User implements Serializable {
    @EmbeddedId
    Operation_UserKey id=new Operation_UserKey()    ;

    @ManyToOne
    @MapsId("UserId")
    @JoinColumn(name = "User_id")
    private User user;
    @ManyToOne
    @MapsId("OperationId")
    @JoinColumn(name = "Operation_id")
    private Operation operation;
    private LocalDateTime dateOperation;
}
