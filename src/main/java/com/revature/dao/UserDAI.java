package com.revature.dao;

import com.revature.model.User;

// Data Access Interface
public interface UserDAI {

	public User getUser(String email);
	
	public boolean insertUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);
}
