package com.junrestwebservice.restfulsnsproject.versioning;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Name {
    private String firstName;
    private String secondName;

    public Name(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
