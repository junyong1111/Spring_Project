package com.spring_jyp_todo.springbootTodoProject.controller;

import com.spring_jyp_todo.springbootTodoProject.Todo;
import com.spring_jyp_todo.springbootTodoProject.repository.TodoRepository;
import com.spring_jyp_todo.springbootTodoProject.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    private final TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "list-todo")
    @GetMapping
    public String listAllTodo(ModelMap model){

        String username = getloggedinUsername(model);
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }



    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getloggedinUsername(model);
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }
    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        String username = getloggedinUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todo";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam(name = "id") int id){
        todoRepository.deleteById(id); // id를 이용하여 삭제
        return "redirect:list-todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String ShowUpdateTodo(@RequestParam(name = "id") int id, ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String UpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        String username = getloggedinUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todo";
    }
    private String getloggedinUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
