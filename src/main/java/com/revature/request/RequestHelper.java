package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.service.RequestService;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {

	public static Object process(HttpServletRequest request) {
		switch (request.getRequestURI()) {
		case "/project1/insertRequest.do":
//			return RequestService.insertRequest(new Request(request));
			return null;
		case "/project1/listRequests.do":
			return RequestService.getAllRequest();
		default:
			return "404.jsp";
		}
	}
}
