package com.spring_jyp_todo.springbootTodoProject.service;

import com.spring_jyp_todo.springbootTodoProject.Todo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public void deleteById(int id){
        Predicate<? super Todo>predicate = todo-> todo.getId() == id;
        todos.removeIf(predicate);
    }


    public Todo findById(int id) {
        Predicate<? super Todo>predicate = todo-> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
