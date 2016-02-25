package com.mrs.service;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.Task;

public interface TaskService {
	public Serializable createTask(Task task);
	public List loadTask();
	public Task getTaskByID(int id);
	public Task updateTask(Task task);
}
