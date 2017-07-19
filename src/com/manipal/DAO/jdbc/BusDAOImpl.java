package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manipal.DAO.BusDAO;
import com.manipal.model.Bus;
import com.manipal.model.City;
import com.manipal.model.Driver;
import com.manipal.model.Dummy;
import com.manipal.model.Operator;
import com.manipal.model.Seat;
import com.manipal.service.impl.CityServiceImpl;
import com.manipal.service.impl.DriverServiceImpl;
import com.mysql.jdbc.*;

public class BusDAOImpl implements BusDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BusDAO.class);

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> searchBuses(String source, String Destination) {
		System.out.println("in bus dao");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Bus bus = null;
		Driver driver = null;
		Operator operator = null;
		Seat seat = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DETAILS WHERE STATUS='ACTIVE' AND SOURCE_CITY=? AND DESTINATION=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, source);
			pst.setString(2, Destination);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {

				operator = new OperatorDAOImpl().retrieveOperator(rs
						.getString("OPERATOR_ID"));
				seat = new SeatDAOImpl().retrieveSeat(rs.getString("SEAT_ID"));
				driver = new DriverServiceImpl().retrieveDriver(rs.getString("DRIVER_ID"));
				bus = new Bus(rs.getString("BUS_ID"),
						rs.getString("BUS_NUMBER"), rs.getString("BUS_TYPE"),
						operator,driver, rs.getString("SOURCE_CITY"),
						rs.getString("DESTINATION"),
						rs.getString("START_TIME"), rs.getString("END_TIME"),
						seat, rs.getString("STATUS"));

				busList.add(bus);
			}
			System.out.println("searching");
			return busList;

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> retrieveActiveBusList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Bus bus = null;
		Driver driver = null;
		Operator operator = null;
		Seat seat = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DETAILS WHERE STATUS='ACTIVE'";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new OperatorDAOImpl().retrieveOperator(rs
						.getString("OPERATOR_ID"));
				seat = new SeatDAOImpl().retrieveSeat(rs.getString("SEAT_ID"));
				driver = new DriverServiceImpl().retrieveDriver(rs.getString("DRIVER_ID"));
				bus = new Bus(rs.getString("BUS_ID"),
						rs.getString("BUS_NUMBER"), rs.getString("BUS_TYPE"),
						operator,driver, rs.getString("SOURCE_CITY"),
						rs.getString("DESTINATION"),
						rs.getString("START_TIME"), rs.getString("END_TIME"),
						seat, rs.getString("STATUS"));
				busList.add(bus);
			}
			

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			e.printStackTrace();
		} finally {
			cleanup(con, pst, rs);
		}
		return busList;
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> retrieveBusList() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Bus bus = null;
		Operator operator = null;
		Driver driver = null;
		Seat seat = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DETAILS";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new OperatorDAOImpl().retrieveOperator(rs
						.getString("OPERATOR_ID"));
				seat = new SeatDAOImpl().retrieveSeat(rs.getString("SEAT_ID"));
				
				driver = new DriverServiceImpl().retrieveDriver(rs.getString("DRIVER_ID"));
				bus = new Bus(rs.getString("BUS_ID"),
						rs.getString("BUS_NUMBER"), rs.getString("BUS_TYPE"),
						operator,driver, rs.getString("SOURCE_CITY"),
						rs.getString("DESTINATION"),
						rs.getString("START_TIME"), rs.getString("END_TIME"),
						seat, rs.getString("STATUS"));
				busList.add(bus);
			}
			return busList;

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public List<Bus> retrieveOperatorBusList(String operatorId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Bus bus = null;
		Operator operator = null;
		Driver driver = null;
		Seat seat = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DETAILS WHERE STATUS='ACTIVE' AND OPERATOR_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, operatorId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new OperatorDAOImpl().retrieveOperator(rs
						.getString("OPERATOR_ID"));
				seat = new SeatDAOImpl().retrieveSeat(rs.getString("SEAT_ID"));
				driver = new DriverServiceImpl().retrieveDriver(rs.getString("DRIVER_ID"));
				bus = new Bus(rs.getString("BUS_ID"),
						rs.getString("BUS_NUMBER"), rs.getString("BUS_TYPE"),
						operator,driver, rs.getString("SOURCE_CITY"),
						rs.getString("DESTINATION"),
						rs.getString("START_TIME"), rs.getString("END_TIME"),
						seat, rs.getString("STATUS"));
				busList.add(bus);
			}
			return busList;

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddBus(String operatorId, String driverId, String seatId,
			Bus bus) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int value = 0;
		String query = "INSERT INTO BUS_DETAILS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = getMySqlConnection();
			
			String sequence = "SELECT * FROM SEQ_BUS_ID";
			pst = (PreparedStatement) con.prepareStatement(sequence);
			rs = (ResultSet) pst.executeQuery();
			if (rs.next()) {
				value = rs.getInt(1);
			}
			String bus_id = "B" + value+1;
			
			String updateValueQuery = "UPDATE SEQ_BUS_ID SET BUS_ID=?";
			pst = (PreparedStatement) con.prepareStatement(updateValueQuery);
			pst.setInt(1,value+1);
			pst.executeUpdate();

			City c1 = new CityServiceImpl().retrieveCityByName(bus.getSourceCity());
			City c2 = new CityServiceImpl().retrieveCityByName(bus.getDestination());

			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, bus_id);
			pst.setString(2, bus.getBusNumber());
			pst.setString(3, bus.getBusType());
			pst.setString(4, operatorId);
			pst.setString(5, driverId);
			pst.setString(6, c1.getCityId());
			pst.setString(7, c2.getCityId());
			pst.setString(8, bus.getStartTime());
			pst.setString(9, bus.getEndTime());
			pst.setString(10, seatId);
			pst.setString(11, "ACTIVE");
			int val = pst.executeUpdate();
			//con.commit();
			if (val != 0)
				return "Bus Added Successfully";
			else
				return "Bus doesn't Added Successfully";

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditBus(String operatorId, String driverId, String seatId,
			String busId, Bus updatedBus) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE BUS_DETAILS SET BUS_NUMBER=?,BUS_TYPE=?,OPERATOR_ID=?,DRIVER_ID=?,SOURCE_CITY=?,DESTINATION=?,START_TIME=?,END_TIME=?,SEAT_ID=?,STATUS=? WHERE BUS_ID=?";
		try {
			con = getMySqlConnection();

			pst = (PreparedStatement) con.prepareStatement(query);
			
			pst.setString(1, updatedBus.getBusNumber());
			pst.setString(2, updatedBus.getBusType());
			pst.setString(3, operatorId);
			pst.setString(4, driverId);
			pst.setString(5, updatedBus.getSourceCity());
			pst.setString(6, updatedBus.getDestination());
			pst.setString(7, updatedBus.getStartTime());
			pst.setString(8, updatedBus.getEndTime());
			pst.setString(9, seatId);
			pst.setString(10, updatedBus.getStatus());
			pst.setString(11, busId);
			int val = pst.executeUpdate();
		//	con.commit();
			if (val != 0)
				return "Bus Updated Successfully";
			else
				return "Bus doesn't Updated Successfully";

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteBus(String busId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE BUS_DETAILS SET STATUS='INACTIVE' WHERE BUS_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, busId);
			int val = pst.executeUpdate();
			//con.commit();
			if (val != 0)
				return "Bus Deleted Successfully";
			else
				return "Bus doesn't Deleted Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> retrieveCityBusList(String cityId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Bus bus = null;
		Driver driver = null;
		Operator operator = null;
		Seat seat = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DETAILS WHERE STATUS='ACTIVE' AND (SOURCE_CITY=? OR DESTINATION=?)";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, cityId);
			pst.setString(2, cityId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new OperatorDAOImpl().retrieveOperator(rs
						.getString("OPERATOR_ID"));
				seat = new SeatDAOImpl().retrieveSeat(rs.getString("SEAT_ID"));
				driver = new DriverServiceImpl().retrieveDriver(rs.getString("DRIVER_ID"));
				bus = new Bus(rs.getString("BUS_ID"),
						rs.getString("BUS_NUMBER"), rs.getString("BUS_TYPE"),
						operator,driver, rs.getString("SOURCE_CITY"),
						rs.getString("DESTINATION"),
						rs.getString("START_TIME"), rs.getString("END_TIME"),
						seat, rs.getString("STATUS"));
				busList.add(bus);
			}
			return busList;

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public Bus retrieveBus(String busId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Bus bus = null;
		Operator operator = null;
		Seat seat = null;
		Driver driver = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DETAILS WHERE BUS_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, busId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				operator = new OperatorDAOImpl().retrieveOperator(rs
						.getString("OPERATOR_ID"));
				seat = new SeatDAOImpl().retrieveSeat(rs.getString("SEAT_ID"));
				driver = new DriverServiceImpl().retrieveDriver(rs.getString("DRIVER_ID"));
				bus = new Bus(rs.getString("BUS_ID"),
						rs.getString("BUS_NUMBER"), rs.getString("BUS_TYPE"),
						operator,driver, rs.getString("SOURCE_CITY"),
						rs.getString("DESTINATION"),
						rs.getString("START_TIME"), rs.getString("END_TIME"),
						seat, rs.getString("STATUS"));

			}
			return bus;

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public List<Dummy> searchBusesWithDate(List<Bus> busList, String departureDate) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Driver driver = null;
		Operator operator = null;
		Seat seat = null;
		List<Dummy> dummyBusList = new ArrayList<Dummy>();
		String query = "SELECT * FROM BUS_DUMMY_DETAILS WHERE BUS_ID=? AND DEPARTURE_DATE=str_to_date(?,'%Y-%m-%d')";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			
			for(Bus bus : busList)
			{
				pst.setString(1, bus.getBusId());
				pst.setString(2,departureDate);
				rs = (ResultSet) pst.executeQuery();
				while(rs.next())
				{
					Dummy dummy = new Dummy(
							rs.getString("BUS_ID"), 
							rs.getString("START_TIME"),
							rs.getString("END_TIME"), 
							rs.getString("DEPARTURE_DATE"), 
							rs.getInt("REMAIN_SEATS"));
					dummyBusList.add(dummy);
				}
			}
			
			return dummyBusList;

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
	
	public void createDummyDB(){
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		Bus bus = null;
		Seat seat = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DETAILS";
		try {

	  		Date date = new Date(2017, 04, 19);
	  		
	  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  		String curDate = sdf.format(date);
	  		System.out.println(curDate);
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			rs = (ResultSet) pst.executeQuery();
			String query123 = "INSERT INTO BUS_DUMMY_DETAILS VALUES(?,?,?,str_to_date(?,'%Y-%m-%d'),?)";
			while (rs.next()) {

				seat = new SeatDAOImpl().retrieveSeat(rs.getString("SEAT_ID"));
				
				System.out.println(seat.getNumberOfSeats());
				pst1 = (PreparedStatement) con.prepareStatement(query123);
				pst1.setString(1, rs.getString("BUS_ID"));
				pst1.setString(2, rs.getString("END_TIME"));
				pst1.setString(3, rs.getString("START_TIME"));
				pst1.setString(4, curDate);
				pst1.setInt(5, seat.getNumberOfSeats());
				
				pst1.executeUpdate();
			//	con.commit();
				
			}

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public Dummy retrieveDummy(String busId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Dummy dummy = null;
		Seat seat = null;
		Driver driver = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "SELECT * FROM BUS_DUMMY_DETAILS WHERE BUS_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, busId);
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				dummy = new Dummy(
						rs.getString("BUS_ID"), 
						rs.getString("START_TIME"),
						rs.getString("END_TIME"), 
						rs.getString("DEPARTURE_DATE"), 
						rs.getInt("REMAIN_SEATS"));

			}
			return dummy;

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public void doReduceSeats(int noOfSeats,Dummy dummy) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Seat seat = null;
		Driver driver = null;
		List<Bus> busList = new ArrayList<Bus>();
		String query = "UPDATE BUS_DUMMY_DETAILS SET REMAIN_SEATS=? WHERE BUS_ID=? AND DEPARTURE_DATE=str_to_date(?,'%Y-%m-%d')";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setInt(1, (dummy.getRemainSeats()-noOfSeats));
			pst.setString(2, dummy.getBusId());
			pst.setString(3, dummy.getDepartureDate().split(" ")[0]);
			pst.executeUpdate();
			//con.commit();

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
		
	}

	@Override
	public int retrieveDriverBus(String driverId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Bus bus = null;
		Driver driver = null;
		Operator operator = null;
		Seat seat = null;
		int val=0;
		String query = "SELECT COUNT(*) FROM BUS_DETAILS WHERE STATUS='ACTIVE' AND DRIVER_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, driverId);
			val = pst.executeUpdate();
			return val;
			

		} catch (Exception e) {
			/* LOGGER.debug(e.getMessage()); */
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public String doActiveBus(String busId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long value = 0;
		String query = "UPDATE BUS_DETAILS SET STATUS='ACTIVE' WHERE BUS_ID=?";
		try {
			con = getMySqlConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, busId);
			int val = pst.executeUpdate();
			//con.commit();
			if (val != 0)
				return "Bus Recovered Successfully";
			else
				return "Bus doesn't Recovered Successfully";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}
}
