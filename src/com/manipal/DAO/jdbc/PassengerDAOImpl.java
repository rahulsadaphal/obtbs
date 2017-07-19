package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manipal.DAO.CityDAO;
import com.manipal.DAO.PassengerDAO;
import com.manipal.model.City;
import com.manipal.model.Passenger;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class PassengerDAOImpl implements PassengerDAO
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PassengerDAO.class);


	@Override
	public String doAddPassengers(List<Passenger> passengerList,String bookingId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;

		try {
			con = getMySqlConnection();
			for(Passenger passenger : passengerList)
			{
				System.out.println(passenger.getPassengerFirstname());
				String query = "INSERT INTO PASSENGER_DETAILS VALUES(?,?,?,?,?,?,?,?)";
				
				String sequence = "SELECT PASSENGER_ID FROM SEQ_PASSENGER_ID";
				pst = (PreparedStatement) con.prepareStatement(sequence);
				rs = (ResultSet) pst.executeQuery();
				if (rs.next()) {
					value = rs.getInt(1);
				}
				String pass_id = "P" + value+1;
				
				String updateValueQuery = "UPDATE SEQ_PASSENGER_ID SET PASSENGER_ID=?";
				pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
				pst.setInt(1,value+1);
				pst.executeUpdate();

				pst = (PreparedStatement) con.prepareStatement(query);
			
				pst.setString(1, pass_id);
				pst.setString(2, passenger.getPassengerFirstname());
				pst.setString(3, passenger.getPassengerLastname());
				pst.setString(4, passenger.getPassengerEmail());
				pst.setString(5, passenger.getPassengerGender());
				pst.setString(6, bookingId);
				pst.setInt(7, passenger.getPassengerAge());
				pst.setLong(8, passenger.getPassengerContact());
				int val = pst.executeUpdate();
				//con.commit();
			}
				return "Passenger Added Successfully";


		} catch (Exception e) {
			/*LOGGER.debug(e.getMessage());*/
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}

	}

	@Override
	public List<Passenger> retrieveBookPassenger(String bookingId) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Passenger passenger = null;
		List<Passenger> passengerList = new ArrayList<Passenger>();
		
		String query = "SELECT * FROM PASSENGER_DETAILS WHERE BOOKING_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, bookingId);
			
			rs = (ResultSet) pst.executeQuery();
			
			while (rs.next()) {
				passenger = new Passenger(
						rs.getString("PASSENGER_ID"),
						rs.getString("PASSENGER_FIRSTNAME"),
						rs.getString("PASSENGER_LASTNAME"),
						rs.getString("PASSENGER_EMAIL"),
						rs.getString("PASSENGER_GENDER"),
						rs.getInt("PASSENGER_age"),
						rs.getLong("PASSENGER_CONTACT")
						);
				passengerList.add(passenger);
			}
			return passengerList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

}
