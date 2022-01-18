package com.example.healthcare_patient.elastic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSearchDto implements Serializable {
    private String firstName;
    private String lastName;
    private String specialProfession;
    private String biography;
    private Integer experienceFrom;
    private Integer experienceTo;


}
