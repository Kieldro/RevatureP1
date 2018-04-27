package com.revature.dao;

import com.revature.model.User;

public interface DBAccess {

	public User getUser(String email);
	
	public boolean insertUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);
}
