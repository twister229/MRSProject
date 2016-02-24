package com.mrs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	HibernateRepository hibernateRepository;
	
	public User login(User user) {
		User result = hibernateRepository.fetchById(user.getUsername(), User.class);
		return result;
	}
	
	
}
