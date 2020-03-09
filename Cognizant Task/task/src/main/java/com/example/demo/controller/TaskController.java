package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repos.TaskRepo;
import com.example.demo.model.Task;

@RestController
public class TaskController
{
	@Autowired
	TaskRepo repo;

	@PostMapping("/saveTask")
	public String addTask(Task task)
	{
		if (task.getTaskName() == null || task.getTaskAssignee() == null ||
				task.getTaskGroup() == null || task.getTimeSpent() == null)
				return Task.error();
		else
			if (task.getTaskParent() == null) {
				task.setTaskParent("none");
				repo.save(task);
				return "success";
			}
		repo.save(task);
		return "success";
	}
	
	@RequestMapping("/getTasks")
	public List<Task> getTask()
	{
		return repo.findAll();
	}
	
	@GetMapping(path="/getTask")
	public Task getTask(@RequestParam("taskName") String taskName)
	{
		return repo.findByTaskName(taskName);
		
		
	}
	
	
	@DeleteMapping("/deleteTask")
	public String deleteTask(@RequestParam String taskName)
	{
		Task task = repo.findByTaskName(taskName);
		repo.delete(task);
		return "deleted";
	}
	
	@PutMapping(path="/updateTask")
	public String saveOrUpdateTask(@RequestBody Task task)
	{
		boolean status = task.isTaskFinished();
		if (status){
			int unfinishedTasks = 0;
			List<Task> tasks = repo.findAll();
			System.out.print(tasks.size());
			for (int i = 0; i < tasks.size(); i++) {
			    if (tasks.get(i).getTaskParent().equals(task.getTaskName()) && ! tasks.get(i).getTaskParent().equals("none") 
			    		&& tasks.get(i).getTaskFinished() == false) {
			    	unfinishedTasks++;
			    	for (int j = 0; j < tasks.size(); j++) {
			    		if (tasks.get(i).getTaskName().equals(tasks.get(j).getTaskParent()) && ! tasks.get(j).getTaskParent().equals("none")
			    				&& tasks.get(j).getTaskFinished() == false ) {
			    			unfinishedTasks++;
			    		}
			    	}
			    }
			}
			
			if (unfinishedTasks >= 1) {
				return "There are other unfinished tasks";
			}
			else {
				repo.save(task);
				return "Updated";
			}
		}
		
		else {
			repo.save(task);
			return "Updated";
		}
	
	}
}