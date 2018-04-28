package com.revature.service;

import java.util.List;

import com.revature.dao.RequestDAO;
import com.revature.model.Request;

public class RequestService {

	private static RequestDAO dao = RequestDAO.getInstance();

	private RequestService() {
	}

	public static Request getRequest(int id) {
		return dao.getRequest(id);
	}

	public static boolean insertRequest(Request r) {
		return dao.insertRequest(r);
	}

	public static boolean updateRequest(Request r) {
		return dao.updateRequest(r);
	}

	public static boolean deleteRequest(Request r) {
		return dao.deleteRequest(r);
	}

	public static List<Request> getAllRequest() {
		return dao.getAllRequests();
	}
}
