package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manipal.DAO.SeatDAO;
import com.manipal.model.Seat;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class SeatDAOImpl implements SeatDAO
{
	private static final Logger LOGGER = LoggerFactory.getLogger(SeatDAO.class);

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Seat> retrieveSeatList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Seat seat = null;
		List<Seat> seatList = new ArrayList<Seat>();
		String query = "SELECT * FROM SEAT_DETAILS";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				seat = new Seat(
						rs.getString("SEAT_ID"),
						rs.getString("SEAT_TYPE"),
						rs.getInt("NUMBER_OF_SEATS"),
						rs.getDouble("FARE"));
				seatList.add(seat);
			}
			return seatList;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public Seat retrieveSeat(String seatId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Seat seat = null;
		String query = "SELECT * FROM SEAT_DETAILS";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				seat = new Seat(
						rs.getString("SEAT_ID"),
						rs.getString("SEAT_TYPE"),
						rs.getInt("NUMBER_OF_SEATS"),
						rs.getDouble("FARE"));
			}
			return seat;

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditSeat(String seatId, Seat updatedseat) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "UPDATE SEAT_DETAILS SET SEAT_TYPE=?,NUMBER_OF_SEATS=?,FARE=? WHERE SEAT_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, updatedseat.getSeatType());
			pst.setInt(2, updatedseat.getNumberOfSeats());
			pst.setDouble(3, updatedseat.getFare());
			pst.setString(4, seatId);
			int val = pst.executeUpdate();
			/*con.commit();*/
			if (val != 0)
				return "Seat updated Successfully";
			else
				return "Seat doesn't updated Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddSeat(Seat seat) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;
		String query = "INSERT INTO SEAT_DETAILS VALUES(?,?,?,?)";
		try {
			con = getMySqlConnection();
			
				String sequence = "SELECT SEAT_ID FROM SEQ_SEAT_ID";
				pst = (PreparedStatement) con.prepareStatement(sequence);
				rs = (ResultSet) pst.executeQuery();
				if (rs.next()) {
					value = rs.getInt(1);
				}
				String seat_id = "S" + value+1;
				
				String updateValueQuery = "UPDATE SEQ_SEAT_ID SET SEAT_ID=?";
				pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
				pst.setInt(1,value+1);
				pst.executeUpdate();

				pst = (PreparedStatement) con.prepareStatement(query);
				pst.setString(1, seat_id);
				pst.setString(2, seat.getSeatType());
				pst.setInt(3, seat.getNumberOfSeats());
				pst.setDouble(4, seat.getFare());
				int val = pst.executeUpdate();
				/*con.commit();*/
				if (val != 0)
					return "Seat Added Successfully";
				else
					return "Seat doesn't Added Successfully";

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

}
