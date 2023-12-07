package com.spring_jyp_todo.springbootTodoProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity
public class Todo {
    public Todo() {

    }
    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min=10, message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    public boolean getDone(){
        return this.done;
    }
    private boolean done;

}
