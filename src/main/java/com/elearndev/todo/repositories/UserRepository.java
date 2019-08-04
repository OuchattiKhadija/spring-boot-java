package com.elearndev.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elearndev.todo.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
