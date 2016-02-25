package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.Task;

public interface TaskDAO {
	public Serializable createTask(Task task);
	public List loadTask();
	public Task getTaskByID(int id);
	public Task updateTask(Task task);
}
