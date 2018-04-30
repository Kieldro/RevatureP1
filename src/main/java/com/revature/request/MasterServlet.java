package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Request;

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
		System.out.println("request.getParameterNames(): " + request.getParameterNames());
		System.out.println("request.getParameter(email): " + request.getParameter("email"));
		System.out.println("request.getRequestURI(): " + request.getRequestURI());

		/* Sets content to be written in PrintWriter as JSON */
		response.setContentType("application/json");
		/*
		 * As you can see, any type of object can be written as a JSON Jackson
		 * specifically requires that objects to be transformed have getters for private
		 * variables
		 */
		Object o = RequestHelper.process(request);
		String responseText = new ObjectMapper().writeValueAsString(o); // marshall object to JSON with Jackson
		System.out.println("responseText: " + responseText);
		response.getWriter().write(responseText);

		System.out.println("doPost() complete.");
	}
}
