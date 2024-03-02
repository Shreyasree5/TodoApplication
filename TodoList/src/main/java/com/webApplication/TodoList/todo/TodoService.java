package com.webApplication.TodoList.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;


@Service
public class TodoService {
	
	
  private static List<Todo> todos = new ArrayList<>();
  
  private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "Shreya","Bath & Yoga by 8 am", 
							LocalDate.now().plusYears(1), false ));
		todos.add(new Todo(++todosCount, "Shreya","Breakfast by 8:30 am", 
				LocalDate.now().plusYears(1), false ));
		todos.add(new Todo(++todosCount, "Shreya","Office work 9:00 am - 2: 00 pm", 
				LocalDate.now().plusYears(1), false ));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate endDate, boolean status) {
		Todo t = new Todo(++todosCount, username, description, endDate, status);
		todos.add(t);
		
	}
	
	public void deleteTodoById(int id) {
		Predicate<? super Todo> Predicate = todo -> todo.getId() == id; 
		todos.removeIf(Predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> Predicate = todo -> todo.getId() == id;
		Todo t = todos.stream().filter(Predicate).findFirst().get();
		return t;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodoById(todo.getId());
		todos.add(todo);
		
	}
	

}
