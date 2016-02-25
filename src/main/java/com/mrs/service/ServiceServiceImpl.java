package com.mrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.ServiceDAO;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceDAO serviceDAO;

	public List getAllService() {
		return serviceDAO.getAllService();
	}

	public com.mrs.entity.Service getService(int serviceID) {
		return serviceDAO.getService(serviceID);
	}
	
}
