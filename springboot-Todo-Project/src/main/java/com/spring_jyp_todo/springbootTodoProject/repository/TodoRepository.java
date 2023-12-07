package com.spring_jyp_todo.springbootTodoProject.repository;

import com.spring_jyp_todo.springbootTodoProject.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username); // Todo Bean에 정의된 username으로 이름 찾기(컬렉션 형태로 반환)

}
