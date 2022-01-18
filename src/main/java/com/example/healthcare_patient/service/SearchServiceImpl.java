package com.example.healthcare_patient.service;


import com.example.healthcare_patient.elastic.DoctorSearchDto;
import com.example.healthcare_patient.elastic.index.Docs;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.util.CollectionUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Override
    public SearchHits<Docs> search(DoctorSearchDto searchDto) {
        QueryBuilder firstName = null;
        if (searchDto.getFirstName() != null) {
            firstName = QueryBuilders.matchQuery("firstName", searchDto.getFirstName()).fuzziness(Fuzziness.TWO);
        }
        QueryBuilder lastName = null;
        if (searchDto.getLastName() != null) {
            lastName = QueryBuilders.matchQuery("lastName", searchDto.getLastName()).fuzziness(Fuzziness.TWO);
        }

        QueryBuilder specialProfession = null;
        if (searchDto.getSpecialProfession() != null) {
            specialProfession = QueryBuilders.termQuery("specialProfession", searchDto.getSpecialProfession());
        }

        QueryBuilder biography = null;
        if (searchDto.getBiography() != null) {
            biography = QueryBuilders.matchQuery("biography", searchDto.getBiography()).fuzziness(Fuzziness.TWO);
        }

        QueryBuilder experience = null;

        if (searchDto.getExperienceFrom() != null && searchDto.getExperienceTo() != null) {
            experience = QueryBuilders.rangeQuery("experience").from(searchDto.getExperienceFrom(), true)
                    .to(searchDto.getExperienceTo(), true);
        } else if (searchDto.getExperienceTo() != null) {
            experience = QueryBuilders.rangeQuery("experience").to(searchDto.getExperienceTo(), true);
        } else if (searchDto.getExperienceFrom() != null) {
            experience = QueryBuilders.rangeQuery("experience").from(searchDto.getExperienceFrom(), true);
        }

        List<QueryBuilder> nonNullBuilders = filter(firstName, lastName, specialProfession, biography, experience);

        BoolQueryBuilder boolQueryBuilder = null;
        if (!CollectionUtils.isEmpty(new List[]{nonNullBuilders})) {
            boolQueryBuilder = QueryBuilders.boolQuery();
            for (QueryBuilder queryBuilder : nonNullBuilders) {
                boolQueryBuilder.must(queryBuilder);
            }
        }

        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withFilter(boolQueryBuilder)
                .build();

        SearchHits<Docs>
                searchHits = elasticsearchOperations.search(query, Docs.class
                , IndexCoordinates.of("docs"));
        return searchHits;

    }

    private List<QueryBuilder> filter(QueryBuilder... queryBuilders) {
        List<QueryBuilder> nonNullBuilders = new ArrayList<>();
        for (QueryBuilder queryBuilder : queryBuilders) {
            if (queryBuilder != null) {
                nonNullBuilders.add(queryBuilder);
            }
        }
        return nonNullBuilders;
    }
}
