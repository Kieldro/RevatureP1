package project1;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.revature.dao.UserDAO;
import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil;

class DAOtests {

	@Test
	void test0() {
		UserDAO dao = UserDAO.getInstance();
		User u = dao.getUser("jane@gmail.com");
		
		System.out.println("User u:" + u);
	}
	@Test
	void test1() {
		Connection con = ConnectionUtil.getConnection();
		User u = UserService.getUser("jane@gmail.com");
		
		System.out.println("User u:" + u);
	}

}
