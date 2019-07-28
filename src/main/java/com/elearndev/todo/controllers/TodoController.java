package com.elearndev.todo.controllers;
import com.elearndev.todo.entities.Todo;
import com.elearndev.todo.repositories.TodoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TodoController {
	
	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping("/todos")
	public List<Todo> index() {
		
		return todoRepository.findAll();
	}
}
