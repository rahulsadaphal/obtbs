package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manipal.DAO.CityDAO;
import com.manipal.DAO.OperatorDAO;
import com.manipal.model.Operator;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class OperatorDAOImpl implements OperatorDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityDAO.class);

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Operator> retrieveOperatorList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Operator operator = null;
		List<Operator> operatorList = new ArrayList<Operator>();
		String query = "SELECT * FROM OPERATOR_DETAILS";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new Operator(rs.getString("OPERATOR_ID"),
						rs.getString("OPERATOR_NAME"),
						rs.getString("OPERATOR_EMAIL"),
						rs.getString("OPERATOR_WEBSITE"),
						rs.getString("OPERATOR_FAX_NUMBER"),
						rs.getString("OPERATOR_ADDRESS"),
						rs.getLong("OPERATOR_CONTACT"), rs.getString("STATUS"));
				operatorList.add(operator);
			}
			return operatorList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Operator> retrieveActiveOperatorList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Operator operator = null;
		List<Operator> operatorList = new ArrayList<Operator>();
		String query = "SELECT * FROM OPERATOR_DETAILS WHERE STATUS='ACTIVE'";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new Operator(rs.getString("OPERATOR_ID"),
						rs.getString("OPERATOR_NAME"),
						rs.getString("OPERATOR_EMAIL"),
						rs.getString("OPERATOR_WEBSITE"),
						rs.getString("OPERATOR_FAX_NUMBER"),
						rs.getString("OPERATOR_ADDRESS"),
						rs.getLong("OPERATOR_CONTACT"), rs.getString("STATUS"));
				operatorList.add(operator);
			}
			return operatorList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public Operator retrieveOperator(String operatorId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Operator operator = null;
		String query = "SELECT * FROM OPERATOR_DETAILS WHERE OPERATOR_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, operatorId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new Operator(rs.getString("OPERATOR_ID"),
						rs.getString("OPERATOR_NAME"),
						rs.getString("OPERATOR_EMAIL"),
						rs.getString("OPERATOR_WEBSITE"),
						rs.getString("OPERATOR_FAX_NUMBER"),
						rs.getString("OPERATOR_ADDRESS"),
						rs.getLong("OPERATOR_CONTACT"), rs.getString("STATUS"));
			}
			return operator;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddOperator(Operator operator) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;
		String query = "INSERT INTO OPERATOR_DETAILS VALUES(?,?,?,?,?,?,?,?)";
		try {
			con = getMySqlConnection();

			String sequence = "SELECT OPERATOR_ID FROM SEQ_OPERATOR_ID";
			pst = (PreparedStatement) con.prepareStatement(sequence);
			rs = (ResultSet) pst.executeQuery();
			if (rs.next()) {
				value = rs.getInt(1);
			}
			String operator_id = "O" + value+1;
			
			String updateValueQuery = "UPDATE SEQ_OPERATOR_ID SET OPERATOR_ID=?";
			pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
			pst.setInt(1,value+1);
			pst.executeUpdate();

			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, operator_id);
			pst.setString(2, operator.getOperatorName());
			pst.setString(3, operator.getOperatorEmail());
			pst.setString(4, operator.getOperatorWebsite());
			pst.setString(5, operator.getOperatorFaxNumber());
			pst.setString(6, operator.getOperatorAddress());
			pst.setLong(7, operator.getOperatorContact());
			pst.setString(8, "ACTIVE");
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Operator Added Successfully";
			else
				return "Operator doesn't Added Successfully";

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditOperator(String operatorId, Operator updatedOperator) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String query = "UPDATE OPERATOR_DETAILS SET OPERATOR_NAME=?,OPERATOR_EMAIL=?,OPERATOR_WEBSITE=?,OPERATOR_FAX_NUMBER=?,OPERATOR_ADDRESS=?,OPERATOR_CONTACT=?,STATUS=? WHERE OPERATOR_ID=?";
		try {
			con = getMySqlConnection();
			pst=(PreparedStatement) con.prepareStatement(query);
			pst.setString(1, updatedOperator.getOperatorName());
			pst.setString(2, updatedOperator.getOperatorEmail());
			pst.setString(3, updatedOperator.getOperatorWebsite());
			pst.setString(4, updatedOperator.getOperatorFaxNumber());
			pst.setString(5, updatedOperator.getOperatorAddress());
			pst.setLong(6, updatedOperator.getOperatorContact());
			pst.setString(7, updatedOperator.getStatus());
			pst.setString(8, operatorId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Operator updated Successfully";
			else
				return "Operator doesn't updated Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteOperator(String operatorId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE OPERATOR_DETAILS SET STATUS='INACTIVE' WHERE OPERATOR_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, operatorId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Operator Deleted Successfully";
			else
				return "Operator doesn't Deleted Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doActiveOperator(String operatorId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE OPERATOR_DETAILS SET STATUS='ACTIVE' WHERE OPERATOR_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, operatorId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Operator Recovered Successfully";
			else
				return "Operator doesn't Recovered Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

}
