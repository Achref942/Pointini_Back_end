package com.example.pointini.entities;

import com.example.pointini.entities.Enum.SensOperation;
import com.example.pointini.entities.Enum.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private double montant;
    private TypeOperation typeOperation;
    private SensOperation sensOperation;
    @OneToMany(mappedBy = "operation")
    private List<Operation_User> operation_user=new ArrayList<>();

}
