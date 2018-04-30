package com.revature.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Servlet that maps every single request that the client makes */
public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = 1159764852861289598L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()...");
		System.out.println("request: " + request);
		System.out.println("request.getAuthType: " + request.getAuthType());
		System.out.println("request.getContentType(): " + request.getContentType());
//		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()...");
		System.out.println("request: " + request);
		System.out.println("request.getAuthType: " + request.getAuthType());
		System.out.println("request.getContentType(): " + request.getContentType());
		System.out.println("request.getMethod(): " + request.getMethod());
		System.out.println("request.getParameter(): " + request.getParameter(getServletName()));
		System.out.println("request.getParameterNames(): " + request.getParameterNames());
		for(Enumeration e : java.util.Arrays.asList(request.getParameterNames())) {
			System.out.println(e);
		}
		System.out.println("request.getRequestURI(): " + request.getRequestURI());
		

		System.out.println("response: " + response);
		
		
		String s = RequestHelper.process(request);
		request.getRequestDispatcher(s).forward(request, response);
		
		System.out.println("doPost() complete.");
	}
}
