package com.junrestwebservice.restfulsnsproject.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.junrestwebservice.restfulsnsproject.posts.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer Id;
    @Size(min=2, message = "Name Should have least 2 characters")
    private String name;
    @Past(message = "Birth Date Should be in the past")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, LocalDate birthDate) {
        Id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
