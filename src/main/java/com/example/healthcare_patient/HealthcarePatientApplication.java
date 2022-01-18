package com.example.healthcare_patient;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.example.healthcare_patient.repository")
@EnableMongock
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HealthcarePatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcarePatientApplication.class, args);
    }

}
