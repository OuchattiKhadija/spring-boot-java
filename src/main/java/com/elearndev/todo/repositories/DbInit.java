package com.elearndev.todo.repositories;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.elearndev.todo.entities.User;


import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

	  private UserRepository userRepository;
	    private PasswordEncoder passwordEncoder;

	    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	    }


    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Create users
        User dan = new User("user", "john doe", passwordEncoder.encode("dan123"), 1,"USER");
        User admin = new User("admin", "Mohamed IDBRAHIM", passwordEncoder.encode("admin123"), 1,"ADMIN");
     

        List<User> users = Arrays.asList(dan,admin);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
