package com.mrs.service;

import java.util.List;

import com.mrs.entity.User;

public interface UserService {

	public User login(User user);
	public List loadUserByRole(int role);
}
