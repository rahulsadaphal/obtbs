package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manipal.DAO.CityDAO;
import com.manipal.model.City;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class CityDAOImpl implements CityDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityDAO.class);

	// -------------------------------------------------------------------------------------------
	@Override
	public List<City> retrieveActiveCityList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		City city = null;
		List<City> cityList = new ArrayList<City>();
		String query = "SELECT * FROM CITY_DETAILS WHERE STATUS='ACTIVE'";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				city = new City(rs.getString("CITY_ID"),
						rs.getString("CITY_NAME"), rs.getString("CITY_STATE"),
						rs.getString("STATUS"));
				cityList.add(city);
			}
			return cityList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<City> retrieveCityList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		City city = null;
		List<City> cityList = new ArrayList<City>();
		String query = "SELECT * FROM CITY_DETAILS";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				city = new City(rs.getString("CITY_ID"),
						rs.getString("CITY_NAME"), rs.getString("CITY_STATE"),
						rs.getString("STATUS"));
				cityList.add(city);
			}
			return cityList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditCity(String cityId, City updatedCity) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "UPDATE CITY_DETAILS SET CITY_NAME=?,CITY_STATE=?,STATUS=? WHERE CITY_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, updatedCity.getCityName());
			pst.setString(2, updatedCity.getCityState());
			pst.setString(3, updatedCity.getStatus());
			pst.setString(4, cityId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "City updated Successfully";
			else
				return "City doesn't updated Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddCity(City city) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;
		String query = "INSERT INTO CITY_DETAILS VALUES(?,?,?,?)";
		try {
			con = getMySqlConnection();

			String sequence = "SELECT CITY_ID FROM SEQ_CITY_ID ";
			pst = (PreparedStatement) con.prepareStatement(sequence);
			rs = (ResultSet) pst.executeQuery();
			if (rs.next()) {
				value = rs.getInt(1);
			}
			String city_id = "C" + value+1;
			
			String updateValueQuery = "UPDATE SEQ_CITY_ID SET CITY_ID=?";
			pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
			pst.setInt(1,value+1);
			pst.executeUpdate();

			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, city_id);
			pst.setString(2, city.getCityName());
			pst.setString(3, city.getCityState());
			pst.setString(4, "ACTIVE");
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "City Added Successfully";
			else
				return "City doesn't Added Successfully";

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteCity(String cityId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE CITY_DETAILS SET STATUS='INACTIVE' WHERE CITY_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, cityId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "City Deleted Successfully";
			else
				return "City doesn't Deleted Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public City retrieveCity(String cityId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		City city = null;
		String query = "SELECT * FROM CITY_DETAILS WHERE CITY_ID =?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, cityId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				city = new City(rs.getString("CITY_ID"),
						rs.getString("CITY_NAME"), rs.getString("CITY_STATE"),
						rs.getString("STATUS"));
			}
			return city;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public String doActiveCity(String cityId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE CITY_DETAILS SET STATUS='ACTIVE' WHERE CITY_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, cityId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "City Recovered Successfully";
			else
				return "City doesn't Recovered Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public City retrieveCityByName(String cityName) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		City city = null;
		String query = "SELECT * FROM CITY_DETAILS WHERE CITY_NAME =?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, cityName);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				city = new City(rs.getString("CITY_ID"),
						rs.getString("CITY_NAME"), rs.getString("CITY_STATE"),
						rs.getString("STATUS"));
			}
			return city;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
}
