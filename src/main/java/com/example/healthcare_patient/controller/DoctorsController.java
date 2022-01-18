package com.example.healthcare_patient.controller;

import com.example.healthcare_patient.elastic.DoctorSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class DoctorsController implements Serializable {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @PostMapping
    public ResponseEntity<?> searchWithinDocs(@RequestBody DoctorSearchDto searchDto) {
        return null;
    }
}
