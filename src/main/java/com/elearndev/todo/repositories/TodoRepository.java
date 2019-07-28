package com.elearndev.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearndev.todo.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
