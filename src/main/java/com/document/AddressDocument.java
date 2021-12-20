package com.document;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddressDocument implements Serializable{
    
    private String addressType;
    private String street;
    private String city;
    private String country;

    public AddressDocument(){
        super();
    }

}
