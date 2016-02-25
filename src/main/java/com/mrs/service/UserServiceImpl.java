package com.mrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.UserDAO;
import com.mrs.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	public User login(User user) {
		return userDAO.login(user);
	}

	public List loadUserByRole(int role) {
		return userDAO.loadUserByRole(role);
	}

}
