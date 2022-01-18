package com.example.healthcare_patient.repository;

import com.example.healthcare_patient.document.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

}
