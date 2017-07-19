package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manipal.DAO.DriverDAO;
import com.manipal.model.Driver;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class DriverDAOImpl implements DriverDAO {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DriverDAO.class);

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Driver> retrieveActiveDriverList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Driver driver = null;
		List<Driver> driverList = new ArrayList<Driver>();
		String query = "SELECT * FROM DRIVER_DETAILS WHERE STATUS='ACTIVE'";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				driver = new Driver(rs.getString("DRIVER_ID"),
						rs.getString("DRIVER_NAME"),
						rs.getString("DRIVER_EMAIL"),
						rs.getString("DRIVER_ADDRESS"),
						rs.getString("DRIVER_LICENCE_NO"),
						rs.getLong("DRIVER_CONTACT"), rs.getString("STATUS"));
				driverList.add(driver);
			}
			return driverList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Driver> retrieveDriverList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Driver driver = null;
		List<Driver> driverList = new ArrayList<Driver>();
		String query = "SELECT * FROM DRIVER_DETAILS";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				driver = new Driver(rs.getString("DRIVER_ID"),
						rs.getString("DRIVER_NAME"),
						rs.getString("DRIVER_EMAIL"),
						rs.getString("DRIVER_ADDRESS"),
						rs.getString("DRIVER_LICENCE_NO"),
						rs.getLong("DRIVER_CONTACT"), rs.getString("STATUS"));
				driverList.add(driver);
			}
			return driverList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public Driver retrieveDriver(String driverId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Driver driver = null;
		String query = "SELECT * FROM DRIVER_DETAILS WHERE DRIVER_ID =?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, driverId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				driver = new Driver(rs.getString("DRIVER_ID"),
						rs.getString("DRIVER_NAME"),
						rs.getString("DRIVER_EMAIL"),
						rs.getString("DRIVER_ADDRESS"),
						rs.getString("DRIVER_LICENCE_NO"),
						rs.getLong("DRIVER_CONTACT"), rs.getString("STATUS"));
			}
			return driver;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditDriver(String driverId, Driver updatedDriver) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "UPDATE DRIVER_DETAILS SET DRIVER_NAME=?,DRIVER_EMAIL=?,DRIVER_ADDRESS=?,DRIVER_LICENCE_NO=?,DRIVER_CONTACT=?,STATUS=? WHERE DRIVER_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, updatedDriver.getDriverName());
			pst.setString(2, updatedDriver.getDriverEmail());
			pst.setString(3, updatedDriver.getDriverAddress());
			pst.setString(4, updatedDriver.getDriverLicenceNumber());
			pst.setLong(5, updatedDriver.getDriverContact());
			pst.setString(6, updatedDriver.getStatus());
			pst.setString(7, driverId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Driver updated Successfully";
			else
				return "Driver doesn't updated Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddDriver(Driver driver) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;
		String query = "INSERT INTO DRIVER_DETAILS VALUES(?,?,?,?,?,?,?)";
		try {
			con = getMySqlConnection();
			
			String sequence = "SELECT DRIVER_ID FROM SEQ_DRIVER_ID";
			pst = (PreparedStatement) con.prepareStatement(sequence);
			rs = (ResultSet) pst.executeQuery();
			if (rs.next()) {
				value = rs.getInt(1);
			}
			String driver_id = "D" + value+1;
			
			String updateValueQuery = "UPDATE SEQ_DRIVER_ID SET DRIVER_ID=?";
			pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
			pst.setInt(1,value+1);
			pst.executeUpdate();
			
			
			pst = (PreparedStatement) con.prepareStatement(query);

			pst.setString(1, driver_id);
			pst.setString(2, driver.getDriverName());
			pst.setString(3, driver.getDriverEmail());
			pst.setString(4, driver.getDriverAddress());
			pst.setString(5, driver.getDriverLicenceNumber());
			pst.setLong(6, driver.getDriverContact());
			pst.setString(7, "ACTIVE");
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Driver Added Successfully";
			else
				return "Driver doesn't Added Successfully";

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteDriver(String driverId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE DRIVER_DETAILS SET STATUS='INACTIVE' WHERE DRIVER_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, driverId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Driver Deleted Successfully";
			else
				return "Driver doesn't Deleted Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Driver> retrieveAvailableDriverList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Driver driver = null;
		List<Driver> driverList = new ArrayList<Driver>();
		String query = "SELECT * FROM DRIVER_DETAILS WHERE STATUS='ACTIVE' AND DRIVER_ID NOT IN(SELECT DRIVER_ID FROM BUS_DETAILS WHERE STATUS='ACTIVE')";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				driver = new Driver(rs.getString("DRIVER_ID"),
						rs.getString("DRIVER_NAME"),
						rs.getString("DRIVER_EMAIL"),
						rs.getString("DRIVER_ADDRESS"),
						rs.getString("DRIVER_LICENCE_NO"),
						rs.getLong("DRIVER_CONTACT"), rs.getString("STATUS"));
				driverList.add(driver);
			}
			return driverList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public String doActiveDriver(String driverId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE DRIVER_DETAILS SET STATUS='ACTIVE' WHERE DRIVER_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, driverId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Driver Recovered Successfully";
			else
				return "Driver doesn't Recovered Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

}
