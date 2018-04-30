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
			System.out.println(request.getParameter("purpose"));
			double amt = Double.parseDouble(request.getParameter("amount"));
			Request r = new Request(0, amt, request.getParameter("email"), request.getParameter("purpose"), 1, null);
			return RequestService.insertRequest(r);
		case "/project1/updateRequest.do":
			int id = Integer.parseInt(request.getParameter("requestId"));
			int status = Integer.parseInt(request.getParameter("status"));
			r = new Request(id, 0, request.getParameter("email"), "", status, null);
			return RequestService.updateRequest(r);
		case "/project1/listRequests.do":
			return RequestService.getAllRequest();
		default:
			return "404.jsp";
		}
	}
}