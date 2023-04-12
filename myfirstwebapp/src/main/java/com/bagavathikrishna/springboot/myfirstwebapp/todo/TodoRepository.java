package com.bagavathikrishna.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo,Integer>{
	public List<Todo> findByUserName(String userName);
	@Query("SELECT MAX(t.id) FROM Todo t WHERE t.userName = :username")
	public int findMaxId(@Param("username") String userName);
}
