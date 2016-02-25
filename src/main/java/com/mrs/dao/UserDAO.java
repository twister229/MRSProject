package com.mrs.dao;

import java.util.List;

import com.mrs.entity.User;

public interface UserDAO {
	
	public User login(User user);
	public List loadUserByRole(int role);

}
