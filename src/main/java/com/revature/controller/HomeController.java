package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Request;

public class HomeController {

	public static String home(HttpServletRequest request) {
		return new Request(3, 2.42, "jane@gmail.com").toString();
	}
}
