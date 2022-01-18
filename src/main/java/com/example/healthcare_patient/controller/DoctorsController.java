package com.example.healthcare_patient.controller;

import com.example.healthcare_patient.elastic.DoctorSearchDto;
import com.example.healthcare_patient.elastic.index.Docs;
import com.example.healthcare_patient.service.SearchService;
import com.example.healthcare_patient.utils.SearchUri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class DoctorsController implements Serializable {

    @Autowired
    private SearchService service;


    @PostMapping(value = SearchUri.SEARCH)
    public ResponseEntity<?> searchWithinDocs(@RequestBody DoctorSearchDto searchDto) {
        SearchHits<Docs> result = service.search(searchDto);
        return ResponseEntity.ok(result);
    }
}
