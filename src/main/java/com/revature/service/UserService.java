package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.model.User;

public class UserService {
	private static UserDAO dao = UserDAO.getInstance();
	
	private UserService() {}
	
	public static User getUser(String email) {
		return dao.getUser(email);
	}
	
//	public static boolean insertUser(User customer) {
//		return dao.insertUser(User);
//	}

//	public static List<Customer> getAllCustomers() {
//		return dao.getAllCustomers();
//	}
}
