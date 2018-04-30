package project1;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.dao.UserDAO;
import com.revature.model.Request;
import com.revature.model.User;
import com.revature.service.RequestService;
import com.revature.service.UserService;

class DAOtests {

	@Test
	void test0() {
//		UserDAO dao = 
				UserDAO.getInstance();
//		User u = dao.getUser("jane@gmail.com");
		
//		System.out.println("User u:" + u);
	}
	@Test
	void test1() {
//		Connection con = ConnectionUtil.getConnection();
		User u = UserService.getUser("jane@gmail.com");
		
		System.out.println("User u:" + u);
	}
	@Test
	void testGetAllRequests() {
		List<Request> l = RequestService.getAllRequest();
		
		System.out.println("Requests:" + l);
	}
	@Test
	void testInsertRequest() {
		Request r = new Request(1, 97.73, "jane@gmail.com", "some reason", 1, null);
		boolean b = RequestService.insertRequest(r);
		
		System.out.println("Insert successful: " + b);
	}
	@Test
	void testUpdateRequest() {
		Request r = new Request(2, 97.73, "jane@gmail.com", "some reason", 2, "keo@gmail.com");
		boolean b = RequestService.updateRequest(r);
		
		System.out.println("Update successful: " + b);
	}
}
