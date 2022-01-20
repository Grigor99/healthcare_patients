package com.example.healthcare_patient.migration;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ChangeLog(order = "101")
public class Logs {

    private final String PATIENT_COLLECTION = "patients";

    @ChangeSet(order = "101", id = "create patients collection", author = "mongock")
    public void createPatientsCollection(MongockTemplate db) {
        if (!db.collectionExists(PATIENT_COLLECTION)) {
            db.createCollection(PATIENT_COLLECTION);
        }
    }


}
