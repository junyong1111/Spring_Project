package com.spring_jyp_todo.springbootTodoProject.service;

import com.spring_jyp_todo.springbootTodoProject.Todo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCnt = 0;


    static {
        todos.add(new Todo(++todoCnt, "PARK","Spring Frame Work", LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(++todoCnt, "PARK","AWS", LocalDate.now().plusYears(2),
                false));

        todos.add(new Todo(++todoCnt, "PARK","DevOps", LocalDate.now().plusYears(3),
                false));

    }
    public List<Todo> findByUsername(String username){
        return todos;
    }
    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todoCnt, username, description, targetDate, done);
        todos.add(todo);
    }


}
