package com.mrs.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.TaskDAO;
import com.mrs.entity.Task;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDAO taskDAO;

	public Serializable createTask(Task task) {
		return taskDAO.createTask(task);
	}

	public List loadTask() {
		return taskDAO.loadTask();
	}

	public Task getTaskByID(int id) {
		return taskDAO.getTaskByID(id);
	}

	public Task updateTask(Task task) {
		return taskDAO.updateTask(task);
	}
	
	
}
