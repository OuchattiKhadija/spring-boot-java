package com.elearndev.todo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todos")
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	private String content;
	private Date date;
	private int active;
	
	public Todo() {}
	
	public Todo(String content, Date date, int active) {
		super();
	
		this.content = content;
		this.date = date;
		this.active = active;
	}
	
	public Todo(long id, String content, Date date, int active) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.active = active;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
