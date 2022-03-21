package com.example.pointini.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FirstNameAndLastNameRequest {
    private  String firstName;
    private  String lastName;
}
