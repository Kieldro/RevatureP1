package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/project1/login.do":
			return LoginController.login(request);
		case "/project1/home.do":
			return HomeController.home(request);
		default:
			return "404.jsp";
		}
	}
}
