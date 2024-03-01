package com.webApplication.TodoList.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {
	
	private int id;
	private String username;
	
	@Size(min=10, message="Enter atleat 10 characters")
	private String description;
	private LocalDate endDate;
	private boolean status;
	
	
	
	
	public Todo(int id, String username, String description, LocalDate endDate, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.endDate = endDate;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", endDate=" + endDate
				+ ", status=" + status + "]";
	}

}
