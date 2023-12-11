package com.junrestwebservice.restfulsnsproject.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.junrestwebservice.restfulsnsproject.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @jakarta.persistence.Id
    @GeneratedValue
    private Integer Id;

    @Size(min = 10)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

}
