package com.example.pointini.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Operation_UserKey implements Serializable {
    @Column(name = "User_id")
    long UserId;
    @Column(name = "Operation_id")
    long OperationId;
}
