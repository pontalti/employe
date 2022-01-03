package com.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddressDocument{
    
    private String addressType;
    private String street;
    private String city;
    private String country;

    public AddressDocument(){
        super();
    }

}
