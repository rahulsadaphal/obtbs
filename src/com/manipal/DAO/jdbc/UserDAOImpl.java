package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manipal.DAO.UserDAO;
import com.manipal.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class UserDAOImpl implements UserDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

	// -------------------------------------------------------------------------------------------
	@Override
	public int loginValidate(String userUsername, String userPassword) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM USER_DETAILS WHERE USER_USERNAME=? AND USER_PASSWORD=? AND STATUS='ACTIVE'";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, userUsername);
			pst.setString(2, userPassword);
			rs = (ResultSet) pst.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			return cnt;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String getFullName(String userUsername) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "SELECT * FROM USER_DETAILS WHERE USER_USERNAME=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, userUsername);
			rs = (ResultSet) pst.executeQuery();
			rs.next();
			String fullName = rs.getString("USER_FIRSTNAME") + " "
					+ rs.getString("USER_LASTNAME");
			return fullName;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddUser(User user) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;
		String query = "INSERT INTO USER_DETAILS VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			con = getMySqlConnection();
			String sequence = "SELECT USER_ID FROM SEQ_USER_ID";
			
			pst = (PreparedStatement) con.prepareStatement(sequence);
			rs = (ResultSet) pst.executeQuery();
			if (rs.next()) {
				value = rs.getInt(1);
			}
			String user_id = "U" + value+1;
			
			String updateValueQuery = "UPDATE SEQ_USER_ID SET USER_ID=?";
			pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
			pst.setInt(1,value+1);
			pst.executeUpdate();

			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, user_id);
			pst.setString(2, user.getUserUsername());
			pst.setString(3, user.getUserPassword());
			pst.setString(4, user.getUserFirstname());
			pst.setString(5, user.getUserLastname());
			pst.setString(6, user.getUserEmail());
			pst.setString(7, user.getUserGender());
			pst.setLong(8, user.getUserContact());
			pst.setString(9, "ACTIVE");
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Account created successfully";
			else
				return "Account doesn't created successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<User> retrieveUserList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		List<User> userList = new ArrayList<User>();
		String query = "SELECT * FROM USER_DETAILS";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("USER_ID"),
						rs.getString("USER_USERNAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_FIRSTNAME"),
						rs.getString("USER_LASTNAME"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_GENDER"),
						rs.getLong("USER_CONTACT"), rs.getString("STATUS"));

				userList.add(user);
			}
			return userList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<User> retrieveActiveUserList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		List<User> userList = new ArrayList<User>();
		String query = "SELECT * FROM USER_DETAILS WHERE STATUS='ACTIVE'";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("USER_ID"),
						rs.getString("USER_USERNAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_FIRSTNAME"),
						rs.getString("USER_LASTNAME"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_GENDER"),
						rs.getLong("USER_CONTACT"), rs.getString("STATUS"));

				userList.add(user);
			}
			return userList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public String doEditUser(String userId, User updatedUser) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "UPDATE USER_DETAILS SET USER_USERNAME=?,USER_PASSWORD=?,USER_FIRSTNAME=?,USER_LASTNAME=?,USER_EMAIL=?,USER_GENDER=?,USER_CONTACT=? WHERE USER_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, updatedUser.getUserUsername());
			pst.setString(2, updatedUser.getUserPassword());
			pst.setString(3, updatedUser.getUserFirstname());
			pst.setString(4, updatedUser.getUserLastname());
			pst.setString(5, updatedUser.getUserEmail());
			pst.setString(6, updatedUser.getUserGender());
			pst.setLong(7, updatedUser.getUserContact());
			pst.setString(8, userId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "User updated Successfully";
			else
				return "User doesn't updated Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteUser(String userId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE USER_DETAILS SET STATUS='INACTIVE' WHERE USER_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, userId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "User Deleted Successfully";
			else
				return "User doesn't Deleted Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public User retrieveUser(String userId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		String query = "SELECT * FROM USER_DETAILS WHERE USER_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, userId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("USER_ID"),
						rs.getString("USER_USERNAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_FIRSTNAME"),
						rs.getString("USER_LASTNAME"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_GENDER"),
						rs.getLong("USER_CONTACT"), rs.getString("STATUS"));
			}
			return user;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
}
