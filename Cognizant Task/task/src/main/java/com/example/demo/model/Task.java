package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String taskName;
private String timeSpent;
private String taskGroup;
private String taskAssignee;
private String taskParent;
private boolean taskFinished;



public static String error () {
	return "Input error";
}
public int getId() {
	return id;
}
public String getTaskName() {
	return taskName;
}
public void setTaskName(String taskName) {
	this.taskName = taskName;
}
public String getTimeSpent() {
	return timeSpent;
}
public void setTimeSpent(String timeSpent) {
	this.timeSpent = timeSpent;
}
public String getTaskGroup() {
	return taskGroup;
}
public boolean getTaskFinished() {
	return taskFinished;
}
public void setTaskGroup(String taskGroup) {
	this.taskGroup = taskGroup;
}
public String getTaskAssignee() {
	return taskAssignee;
}
public void setTaskAssignee(String taskAssignee) {
	this.taskAssignee = taskAssignee;
}
public String getTaskParent() {
	return taskParent;
}
public void setTaskParent(String taskParent) {
	this.taskParent = taskParent;
}
public boolean isTaskFinished() {
	return taskFinished;
}
public void setTaskFinished(boolean taskFinished) {
	this.taskFinished = taskFinished;
}
public void setId(int id) {
	this.id = id;
}

}