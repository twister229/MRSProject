package com.mrs.service;

import java.util.List;

import com.mrs.entity.Service;

public interface ServiceService {
	public List getAllService();
	public Service getService(int serviceID);
}
