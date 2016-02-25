package com.mrs.dao;

import java.util.List;

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

	public List loadUserByRole(int role) {
		String query = String.format("WHERE role = '%d'", role);
		return hibernateRepository.fetchAllByQuery(query, User.class);
	}
	
	
}
