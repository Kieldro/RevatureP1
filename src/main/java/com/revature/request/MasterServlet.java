package com.revature.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.ajax.RequestHelper;

/* Servlet that maps every single request that the client makes */
public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = 1159764852861289598L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()...");
		System.out.println("request: " + request);
		// System.out.println("request.getAuthType: " + request.getAuthType());
		// System.out.println("request.getContentType(): " + request.getContentType());
		// request.getRequestDispatcher(RequestHelper.process(request)).forward(request,
		// response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()...");
		System.out.println("request: " + request);
		// System.out.println("request.getAuthType: " + request.getAuthType());
		// System.out.println("request.getContentType(): " + request.getContentType());
		// System.out.println("request.getMethod(): " + request.getMethod());
		 System.out.println("request.getParameterNames(): " + request.getParameterNames());
		 System.out.println("request.getParameter(email): " + request.getParameter("email"));
		 
		// for(Enumeration e : java.util.Arrays.asList(request.getParameterNames())) {
		// System.out.println(e);
		// }
		System.out.println("request.getRequestURI(): " + request.getRequestURI());

		System.out.println("RequestHelper.process(request): " + RequestHelper.process(request));
//		String s = RequestHelper.process(request);
//		request.getRequestDispatcher(s).forward(request, response);


		/* Sets content to be written in PrintWriter as JSON */
//		response.setContentType("application/json");
		/*
		 * As you can see, any type of object can be written as a JSON Jackson
		 * specifically requires that objects to be transformed have getters for private
		 * variables
		 */
//		String responseText = new ObjectMapper().writeValueAsString(RequestHelper.process(request, response));
		String responseText = "HALLO LOL";
		response.getWriter().write(responseText);
		System.out.println("response: " + response);
		
		System.out.println("doPost() complete.");
	}
}
