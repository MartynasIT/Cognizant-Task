package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Task;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,String>
{
	
	Task findByTaskName(String name);


}