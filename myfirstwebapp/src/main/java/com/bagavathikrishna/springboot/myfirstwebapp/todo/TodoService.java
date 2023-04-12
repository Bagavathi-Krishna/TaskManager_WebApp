package com.bagavathikrishna.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<>();
	public static int count=0;
	static {
		todos.add(new Todo(++count,"Bagavathi","Learn Springboot",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count,"Krishna","Learn JPA",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count,"Haritha","Learn Hibernate",
				LocalDate.now().plusYears(1),false));
	}
public List<Todo> findByUserName(String userName)
{
	Predicate<? super Todo> predicate = 
			todo -> todo.getUserName().equalsIgnoreCase(userName);
	return todos.stream().filter(predicate).toList();
}
public void addTodoInList(String username,String desc,LocalDate d,boolean status)
{

		todos.add(new Todo(count++,username,desc,d,status));
	
	
}
public void deleteById(int id)
{
	Predicate<? super Todo> predicate=todo -> todo.getId()==id;
	todos.removeIf(predicate);
}
public Todo findById(int id)
{
	Predicate<? super Todo> predicate=todo -> todo.getId()==id;
	Todo todo=todos.stream().filter(predicate).findFirst().get();
	return todo;
}
public void updateTodo(Todo todo)
{
	deleteById(todo.getId());
	todos.add(todo);
	
}
}
