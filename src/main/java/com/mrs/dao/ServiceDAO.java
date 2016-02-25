package com.mrs.dao;

import java.util.List;

import com.mrs.entity.Service;

public interface ServiceDAO {
	public List getAllService();
	public Service getService(int serviceID);
}
