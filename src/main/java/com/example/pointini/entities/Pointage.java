package com.example.pointini.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.LocalDateTimeType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pointage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime arrive= LocalDateTime.now();
    private LocalDateTime sortir= LocalDateTime.now();
    private LocalDate date= LocalDate.now();
    private boolean etat;
    @ManyToOne()
    private User user;


}
