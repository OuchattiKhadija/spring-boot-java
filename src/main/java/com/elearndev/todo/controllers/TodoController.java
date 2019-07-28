package com.elearndev.todo.controllers;
import com.elearndev.todo.entities.Todo;
import com.elearndev.todo.repositories.TodoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoController {
	
	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping("/todos")
	public List<Todo> index() {
		
		return todoRepository.findAll();
	}
	
	@GetMapping("/todos/{id}")
	public Optional<Todo> show(@PathVariable long id) {
		
		return todoRepository.findById(id);
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<?> destroy(@PathVariable long id) {
		Optional<Todo> myTodo = todoRepository.findById(id);
		if(myTodo!=null) {
			todoRepository.delete(myTodo.get());
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
}
