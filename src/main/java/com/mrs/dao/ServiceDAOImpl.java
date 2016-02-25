package com.mrs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Service;

@Repository
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private HibernateRepository repository;

	public List getAllService() {
		return repository.fetchAll(Service.class);
	}

	public Service getService(int serviceID) {
		return repository.fetchById(serviceID, Service.class);
	}
	
	
}
