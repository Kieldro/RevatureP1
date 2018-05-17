package com.revature.dao;

import java.util.List;

import com.revature.model.Request;

//Data Access Interface
public interface RequestDAI {
	public Request getRequest(int id);

	public boolean insertRequest(Request r);

	public boolean updateRequest(Request r);

	public boolean deleteRequest(Request r);

	public List<Request> getAllRequests();
}