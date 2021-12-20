package com.document;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "Employe")
public class EmployeDocument implements Serializable{
    
    @Id
    private String id;
    private String name;
    private String surname;

    @Indexed
    private Integer salary;

    @Field("emails")
    private Set<String> emails;

    private Set<AddressDocument> address;

    public EmployeDocument(){
        super();
    }

}
