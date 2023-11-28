package com.spring_jyp_todo.springbootTodoProject.controller;

import com.spring_jyp_todo.springbootTodoProject.Todo;
import com.spring_jyp_todo.springbootTodoProject.service.TodoService;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller

@SessionAttributes("name")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "list-todo")
    @GetMapping
    public String listAllTodo(ModelMap model){
        List<Todo> todos = todoService.findByUsername("PARK");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(){
        return "todo";
    }
    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam(name="description") String description,
                             @RequestParam(name="Year") int year, ModelMap model){
        String username = (String)model.get("name");
        todoService.addTodo(username, description, LocalDate.now().plusYears(year), false);
        return "redirect:list-todo";
    }
}
