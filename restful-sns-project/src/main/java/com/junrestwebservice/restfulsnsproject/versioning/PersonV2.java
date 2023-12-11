package com.junrestwebservice.restfulsnsproject.versioning;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonV2 {
    private final Name name;
    public PersonV2(Name name) {
        this.name = name;
    }
}
