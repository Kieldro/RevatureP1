package com.revature.dao;

import static com.revature.util.ConnectionUtil.logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Request;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

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
			logger.debug("insertRequest()...");
			try (Connection con = ConnectionUtil.getConnection()) {
				int idx = 0;
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO request (amount, email) VALUES (?, ?)");
				ps.setDouble(++idx, r.getAmount());
				ps.setString(++idx, r.getEmail());

				logger.debug("executing INSERT...");
				return ps.executeUpdate() > 0;
			} catch (SQLException e) {
				System.err.print(e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error code: " + e.getErrorCode());
			}

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
			logger.debug("getAllRequests()...");
			List<Request> requests = new ArrayList<>();
			try (Connection con = ConnectionUtil.getConnection()) {
				PreparedStatement stmt = con.prepareStatement("SELECT id, amount, email FROM request");
				ResultSet rs = stmt.executeQuery();
				logger.debug("query done.");
				while (rs.next()) {
					requests.add(new Request(rs.getInt("id"), rs.getDouble("amount"), rs.getString("email")));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error code: " + e.getErrorCode());
			}

//			logger.debug("No requests found (Result set empty)");
			return requests;
		}

}
