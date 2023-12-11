package com.junrestwebservice.restfulsnsproject.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping(value = "/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("PARK JUN YONG");
    }

    @GetMapping(value = "/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        Name name = new Name("JUNYONG", "PARK");
        return new PersonV2(name);
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequerstParameter(){
        return new PersonV1("PARK JUN YONG");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequerstParameter(){
        Name name = new Name("JUNYONG", "PARK");
        return new PersonV2(name);
    }

}
