package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username){
        return todoService.findByUsername(username);
    }

    @GetMapping(value = "/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username,
                                   @PathVariable int id){
        return todoService.findById(id);
    }

    @DeleteMapping(value = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                       @PathVariable int id){
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username,
                           @PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(todo);
        return todo;
    }

    @PostMapping(value = "/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo mytodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return mytodo;
    }
}
