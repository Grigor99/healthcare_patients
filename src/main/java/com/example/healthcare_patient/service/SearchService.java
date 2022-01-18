package com.example.healthcare_patient.service;

import com.example.healthcare_patient.elastic.DoctorSearchDto;
import com.example.healthcare_patient.elastic.index.Docs;
import org.springframework.data.elasticsearch.core.SearchHits;

public interface SearchService {
    SearchHits<Docs> search(DoctorSearchDto searchDto);
}
