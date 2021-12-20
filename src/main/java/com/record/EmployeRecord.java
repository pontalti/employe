package com.record;

import java.util.Set;

public record EmployeRecord(String              id, 
                            String              name, 
                            String              surname, 
                            Double              salary, 
                            Set<String>         emails, 
                            Set<AddressRecord>  address) {

}
