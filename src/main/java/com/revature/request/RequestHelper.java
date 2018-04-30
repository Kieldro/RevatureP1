package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.model.Request;
import com.revature.service.RequestService;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {

	public static Object process(HttpServletRequest request) {
		switch (request.getRequestURI()) {
		case "/project1/insertRequest.do":
			double amt = Double.parseDouble(request.getParameter("amount"));
			Request r = new Request(0, amt, request.getParameter("email"), "", 1, null);
			return RequestService.insertRequest(r);
		case "/project1/listRequests.do":
			return RequestService.getAllRequest();
		default:
			return "404.jsp";
		}
	}
}