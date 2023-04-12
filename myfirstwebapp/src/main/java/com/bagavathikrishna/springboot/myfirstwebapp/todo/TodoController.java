package com.bagavathikrishna.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	private TodoService todoService;

	
	@Autowired
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
		
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap m)
	{
		String username = getLoggedInUsername(m);
		List<Todo> list=todoService.findByUserName(username);
		m.put("l1", list);
		return "listTodos";
	}
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model)
	{
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "Todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap m,@Valid Todo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "Todo";
		}
		String username=getLoggedInUsername(m);
		todoService.addTodoInList(username,todo.getDescription(),
				todo.getTargetDate(),false);
		return "redirect:list-todos";
	}
	@RequestMapping("delete-todo")
	public String deleteExsistingTodo(@RequestParam int id)
	{
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model)
	{
		Todo todo=todoService.findById(id);
		model.put("todo", todo);
		return "Todo";
	}

	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateNewTodo(ModelMap m,@Valid Todo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "Todo";
		}
		String username=getLoggedInUsername(m);
		todo.setUserName(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
