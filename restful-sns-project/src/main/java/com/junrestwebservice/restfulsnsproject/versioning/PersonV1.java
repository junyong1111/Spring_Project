package com.junrestwebservice.restfulsnsproject.versioning;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PersonV1 {
    private String name;
    public PersonV1(String name) {
        this.name = name;

    }
}
