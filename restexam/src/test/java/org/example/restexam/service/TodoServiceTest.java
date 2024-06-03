package org.example.restexam.service;

import org.example.restexam.domain.Todo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class TodoServiceTest {
    @Autowired TodoService service;
    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);

    @Test
    void getTodos() {
        List<Todo> todos = service.getTodos();
        todos.forEach(todo -> log.info("Todo:::"+todo));
    }

    @Test
    void getTodo() {
    }

    @Test
    void addTodo() {
        Todo todo1 = service.addTodo("Todo1");
        log.info("Todo::::"+todo1);
    }

    @Test
    void updateTodo() {
    }

    @Test
    void testUpdateTodo() {
    }

    @Test
    void deleteTodo() {
    }
}