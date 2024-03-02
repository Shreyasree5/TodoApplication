package com.webApplication.TodoList.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
private TodoService ts;
private TodoRepository tr;
	
	public TodoControllerJpa(TodoService ts, TodoRepository tr) {
		super();
		this.ts = ts;
		this.tr = tr;
	}

	@RequestMapping("todosList")
	public String listAllTodos(ModelMap m) {
		String username = getLoggedInUsername(m);
		List<Todo> todos = tr.findByUsername(username);
		m.addAttribute("todos", todos);
		
		return "todoList";
	}
	
	@RequestMapping(value= "addTodos", method = RequestMethod.GET)
	public String showNewTodo(ModelMap m) {
		String username = getLoggedInUsername(m);
		Todo t = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		m.put("todo", t);
		
		return "addTodo";
	}
	
	@RequestMapping(value= "addTodos", method = RequestMethod.POST)
	public String addNewTodo(ModelMap m, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username = getLoggedInUsername(m);
		todo.setUsername(username);
		tr.save(todo);
		//ts.addTodo(username, todo.getDescription(), todo.getEndDate(), todo.isStatus());
		return "redirect:todosList";
	}
	
	@RequestMapping("deleteTodo")
	public String deleteTodo(@RequestParam int id) {
		
		ts.deleteTodoById(id);
		return "redirect:todosList";
	}
	
	@RequestMapping(value= "updateTodo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap m) {
		Todo t = ts.findById(id);
		m.addAttribute("todo", t);
		return "addTodo";
	}
	
	@RequestMapping(value= "updateTodo", method = RequestMethod.POST)
	public String updateTodo(ModelMap m, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username = getLoggedInUsername(m);
		todo.setUsername(username);
		ts.updateTodo(todo);
		return "redirect:todosList";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}