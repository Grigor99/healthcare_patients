package com.example.healthcare_patient.elastic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.Instant;

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
