package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {

	@Autowired
	private HibernateRepository repository;

	public Serializable createTask(Task task) {
		return repository.create(task);
	}

	public List loadTask() {
		return repository.fetchAll(Task.class);
	}

	public Task getTaskByID(int id) {
		return repository.fetchById(id, Task.class);
	}

	public Task updateTask(Task task) {
		return repository.update(task);
	}
	
}
