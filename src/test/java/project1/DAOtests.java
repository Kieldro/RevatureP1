package project1;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.revature.dao.DBAccessor;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

class DAOtests {

	@Test
	void test0() {
		DBAccessor dao = DBAccessor.getInstance();
		User u = dao.getUser("jane@gmail.com");
		
		System.out.println("User u:" + u);
	}
	@Test
	void test1() {
		Connection con = ConnectionUtil.getConnection();
//		User u = dao.getUser("jane@gmail.com");
		
//		System.out.println("User u:" + u);
	}

}
