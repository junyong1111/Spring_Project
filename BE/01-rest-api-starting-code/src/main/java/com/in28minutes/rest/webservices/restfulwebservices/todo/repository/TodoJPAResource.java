package com.in28minutes.rest.webservices.restfulwebservices.todo.repository;

import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.todo.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJPAResource {
    private final TodoRepository todoRepository;

    public TodoJPAResource(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }

    @GetMapping(value = "/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username){
        return todoRepository.findByUsername(username);
    }

    @GetMapping(value = "/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username,
                                   @PathVariable int id){
        return todoRepository.findById(id).get();
    }

    @DeleteMapping(value = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                       @PathVariable int id){
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username,
                           @PathVariable int id, @RequestBody Todo todo){

        todoRepository.save(todo);
        return todo;
    }

    @PostMapping(value = "/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo){
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
    }
}
