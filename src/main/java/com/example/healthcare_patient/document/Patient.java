package com.example.healthcare_patient.document;

import com.example.healthcare_patient.document.imo.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patients")
public class Patient implements Serializable {
    @Id
    private String id;

    @Version
    private Long version;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "username")
    private String username;

    @Field(name = "password")
    private String password;

    @CreatedDate
    @Field(name = "created_at")
    private Instant createdAt;

    @LastModifiedDate
    @Field(name = "last_modified")
    private Instant lastModified;

    @Field(name = "removed")
    private boolean removed;

    @Field(name = "authorities")
    private String authorities = UserType.PATIENT.getLabel();

    @Field(name = "code")
    private String code;

    @Field(name = "status")
    private STATUS status;

    public enum STATUS {
        REGISTERED, ACTIVE, BLOCKED;
    }


}
