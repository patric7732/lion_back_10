package org.example.restexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }
}
