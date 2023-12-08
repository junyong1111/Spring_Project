package com.junrestwebservice.restfulsnsproject.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private Integer Id;
    @Size(min=2, message = "Name Should have least 2 characters")
    private String name;
    @Past(message = "Birth Date Should be in the past")
    private LocalDate birthDate;
}
