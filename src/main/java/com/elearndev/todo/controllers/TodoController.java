package com.elearndev.todo.controllers;
import com.elearndev.todo.entities.Todo;
import com.elearndev.todo.entities.Todobody;
import com.elearndev.todo.repositories.TodoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/todos")
	public ResponseEntity<Object> store(@RequestBody Todo todo) {
		
		Todo myTodo = new Todo(todo.getContent(), todo.getDate(), todo.getActive());
		todoRepository.save(myTodo);
		
		return new ResponseEntity<Object>(myTodo, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<Object> update(@RequestBody Todo todo,@PathVariable long id) {
		
		//Retreive one instance of todo object
		Todo myTodo = todoRepository.getOne(id);
		
		//update todo from body 
		myTodo.setContent(todo.getContent());
		myTodo.setDate(new Date());
		myTodo.setActive(todo.getActive());
		
		//commit update in the database
		 Todo todoUpdated = todoRepository.save(myTodo);
		
		//retrun result to our front with object data including this status
		return new ResponseEntity<Object>(todoUpdated, HttpStatus.ACCEPTED);
		
	}
	
	@PatchMapping("/todos/{id}")
	public ResponseEntity<Object> updateActive(@RequestBody Todobody todo,@PathVariable long id) {
		
		//Retreive one instance of todo object
		Todo myTodo = todoRepository.getOne(id);
		
		//update active in todo object from param 
		myTodo.setActive(todo.getActive());
		
		//commit update in the database
		 Todo todoUpdated = todoRepository.save(myTodo);
		
		//retrun result to our front with object data including this status
		return new ResponseEntity<Object>(todoUpdated, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/todos/{id}")
	public ResponseEntity<Object> show(@PathVariable long id) {
		
		return new ResponseEntity<Object>(todoRepository.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<?> destroy(@PathVariable long id) {
		Optional<Todo> myTodo = todoRepository.findById(id);
		if(myTodo.isPresent()) {
			todoRepository.delete(myTodo.get());
			return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Object>("todo not found", HttpStatus.NOT_FOUND);
		}
		
		
		
	}
}
