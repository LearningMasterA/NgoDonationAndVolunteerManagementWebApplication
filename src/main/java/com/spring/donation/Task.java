package com.spring.donation;

import java.sql.Timestamp;

public class Task {
	private int id;
	private int volunteerId;
	private String taskDescription;
	private Timestamp assignedDate;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVolunteerId() {
		return volunteerId;
	}
	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Timestamp getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(Timestamp assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Task(int id, int volunteerId, String taskDescription, Timestamp assignedDate, String status) {
		super();
		this.id = id;
		this.volunteerId = volunteerId;
		this.taskDescription = taskDescription;
		this.assignedDate = assignedDate;
		this.status = status;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", volunteerId=" + volunteerId + ", taskDescription=" + taskDescription
				+ ", assignedDate=" + assignedDate + ", status=" + status + "]";
	}
	

}
