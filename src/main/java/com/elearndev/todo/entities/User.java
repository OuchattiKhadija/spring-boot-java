package com.elearndev.todo.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	
	private String name;
	
	private String password;
	
	private int active;
	
	private String roles;
	
	public User() {}
	
	public User(String username, String name, String password, int active, String roles) {
		super();
		
		this.username = username;
		this.name = name;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public User(long id, String username, String name, String password, int active, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	 public List<String> getRoleList(){
	        if(this.roles.length() > 0){
	            return Arrays.asList(this.roles.split(","));
	        }
	        return new ArrayList<>();
	    }
	
}
