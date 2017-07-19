package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.util.ArrayList;
import java.util.List;

import com.manipal.DAO.BookingDAO;
import com.manipal.model.Booking;
import com.manipal.model.Bus;
import com.manipal.model.Dummy;
import com.manipal.service.impl.BusServiceImpl;
import com.mysql.jdbc.*;

public class BookingDAOImpl implements BookingDAO{

	@Override
	public String doAddBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		String arr[] = booking.getDummy().getDepartureDate().split(" ");
		String dept = arr[0];
		System.out.println("dep"+dept);
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;
		String query = "INSERT INTO BOOKING_DETAILS VALUES(?,?,?,?,SYSDATE(),str_to_date(?,'%Y-%m-%d'),?)";
		try {
			con = getMySqlConnection();
			String sequence = "SELECT BOOKING_ID FROM SEQ_BOOKING_ID";
			pst = (PreparedStatement) con.prepareStatement(sequence);
			rs = (ResultSet) pst.executeQuery();
			
			if (rs.next()) {
				value = rs.getInt(1);
			}
			String booking_id = "BK" + value+1;
			
			String updateValueQuery = "UPDATE SEQ_BOOKING_ID SET BOOKING_ID=?";
			pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
			pst.setInt(1,value+1);
			pst.executeUpdate();
			
			
			pst = (PreparedStatement) con.prepareStatement(query);
			
			Bus bus = new BusDAOImpl().retrieveBus(booking.getDummy().getBusId());
			
			pst.setString(1, booking_id);
			pst.setString(2, bus.getSourceCity());
			pst.setString(3, bus.getDestination());
			pst.setString(4, bus.getBusId());
			pst.setString(5, dept);
			pst.setInt(6, booking.getNumberOfSeatsBooked());
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return booking_id;
			else
				return "Booking doesn't done Successfully";

		} catch (Exception e) {
			/*LOGGER.debug(e.getMessage());*/
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public Booking retrieveBooking(String bookingId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Booking booking = null;
		String query = "SELECT * FROM BOOKING_DETAILS WHERE BOOKING_ID =?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, bookingId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				
				Dummy dummy = new BusServiceImpl().retrieveDummy(rs.getString("BUS_ID"));
				booking = new Booking(
						rs.getString("BOOKING_ID"),
						dummy,
						rs.getDate("BOOKING_DATE"),
						rs.getInt("NUMBER_OF_SEATS_BOOKED")
						);
			}
			return booking;

		} catch (Exception e) {
			/*LOGGER.debug(e.getMessage());*/
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public List<Booking> retrieveBusBooking(String busId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Booking booking = null;
		List<Booking> bookingList = new ArrayList<Booking>();
		String query = "SELECT * FROM BOOKING_DETAILS WHERE BUS_ID =?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, busId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				
				Dummy dummy = new BusServiceImpl().retrieveDummy(rs.getString("BUS_ID"));
				booking = new Booking(
						rs.getString("BOOKING_ID"),
						dummy,
						rs.getDate("BOOKING_DATE"),
						rs.getInt("NUMBER_OF_SEATS_BOOKED")
						);
				bookingList.add(booking);
			}
			return bookingList;

		} catch (Exception e) {
			/*LOGGER.debug(e.getMessage());*/
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

}
