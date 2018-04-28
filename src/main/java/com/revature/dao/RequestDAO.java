package com.revature.dao;

import static com.revature.util.ConnectionUtil.logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Request;

public class RequestDAO implements RequestDAI{
		private static RequestDAO instance;

		private RequestDAO() {
		}

		public static RequestDAO getInstance() {
			if (instance == null) {
				instance = new RequestDAO();
			}
			return instance;
		}

		public Request getRequest(int id) {
//			try (Connection con = ConnectionUtil.getConnection()) {
//				PreparedStatement ps = con.prepareStatement(
//						"SELECT email, password, firstName, lastName, manager FROM employee WHERE email = ?");
//				ps.setString(1, email);
//				logger.trace("getUser query executing...");
//				ResultSet rs = ps.executeQuery();
//				logger.trace("query done.");
//				if (rs.next()) {
//					return new User(rs.getString("email"), rs.getString("password"), rs.getString("firstName"),
//							rs.getString("lastName"), rs.getBoolean("manager"));
//				}
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//				System.err.println("SQL State: " + e.getSQLState());
//				System.err.println("Error code: " + e.getErrorCode());
//			}

			logger.debug("No Request found (Result set empty)");
			return null;

		}

		public boolean insertRequest(Request r) {
//			try (Connection con = ConnectionUtil.getConnection()) {
//				int idx = 0;
//				PreparedStatement ps = con.prepareStatement(
//						"INSERT INTO employee (email, password, firstName, lastName, manager) " + "VALUES (?, ?, ?, ?, ?)");
//				ps.setString(++idx, u.getEmail());
//				ps.setString(++idx, u.getPassword());
//				ps.setString(++idx, u.getFirstName());
//				ps.setString(++idx, u.getLastName());
//				ps.setBoolean(++idx, u.isManager());
//
//				logger.trace("executing INSERT...");
//				return ps.executeUpdate() > 0;
//			} catch (SQLException e) {
//				System.err.print(e.getMessage());
//				System.err.println("SQL State: " + e.getSQLState());
//				System.err.println("Error code: " + e.getErrorCode());
//			}

			logger.debug("INSERT Request failed: " + r);
			return false;
		}
		
		public boolean updateRequest(Request r) {
			// UPDATE user_account SET balance = 4.0, approved = 0 WHERE name = ?;
//			try (Connection con = ConnectionUtil.getConnection()) {
//				int idx = 0;
//				PreparedStatement ps = con.prepareStatement(
//				"UPDATE employee SET password = ?, firstName = ?, lastName= ?, manager= ? WHERE email= ?");
//				ps.setString(++idx, u.getPassword());
//				ps.setString(++idx, u.getFirstName());
//				ps.setString(++idx, u.getLastName());
//				ps.setBoolean(++idx, u.isManager());
//
//				logger.trace("executing UPDATE to User..." + u);
//				return ps.executeUpdate() > 0;
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//				System.err.println("SQL State: " + e.getSQLState());
//				System.err.println("Error code: " + e.getErrorCode());
//			}

			logger.debug("UPDATE Request modified 0 rows: " + r);
			return false;
		}

		public boolean deleteRequest(Request r) {
//			try (Connection con = ConnectionUtil.getConnection()) {
//				PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE email = ?");
//				ps.setString(1, u.getEmail());
//
//				logger.trace("executing DELETE...");
//				return ps.executeUpdate() > 0;
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//				System.err.println("SQL State: " + e.getSQLState());
//				System.err.println("Error code: " + e.getErrorCode());
//			}

			logger.debug("DELETE Request failed: " + r);
			return false;
		}

		@Override
		public List<Request> getAllRequests() {
			// Try-with-Resources will automatically close your resources,
			// In the reverse order in which you declared them
			// ***Available since Java 7
//			try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
//				// 1. Create a List<Customer>
//				List<Request> customers = new ArrayList<>();
//				
//				// 2. Create a Statement Object
//				PreparedStatement stmt = conn.prepareStatement("SELECT firstname, lastname, email FROM customer");
//				ResultSet rs = stmt.executeQuery();
//				while (rs.next()) {
//					customers.add(new Request(rs.getString("firstname"), rs.getString(2), rs.getString("email")));
//				}
//				// Return the populated list
//				return customers;
//			} catch (SQLException sqle) {
//				System.err.println(sqle.getMessage());
//				System.err.println("SQL State: " + sqle.getSQLState());
//				System.err.println("Error Code: " + sqle.getErrorCode());
//			} 
			return null;
		}

}
