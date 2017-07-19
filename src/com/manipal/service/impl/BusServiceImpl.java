package com.manipal.service.impl;

import java.sql.Date;
import java.util.List;

import com.manipal.DAO.BusDAO;
import com.manipal.DAO.jdbc.BusDAOImpl;
import com.manipal.model.Bus;
import com.manipal.model.Dummy;
import com.manipal.service.BusService;

public class BusServiceImpl implements BusService {
	BusDAO busDAO;

	public BusServiceImpl() {
		busDAO = new BusDAOImpl();
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> searchBuses(String source, String destination) {
		return busDAO.searchBuses(source, destination);
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> retrieveActiveBusList() {
		// TODO Auto-generated method stub
		return busDAO.retrieveActiveBusList();
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> retrieveBusList() {
		// TODO Auto-generated method stub
		return busDAO.retrieveBusList();
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> retrieveOperatorBusList(String operatorId) {
		// TODO Auto-generated method stub
		return busDAO.retrieveOperatorBusList(operatorId);
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddBus(String operatorId, String driverId, String seatId,
			Bus bus) {
		List<Bus> busList = busDAO.retrieveBusList();
		if (busList.size() != 0) {
			for (Bus dbBus : busList) {
				if (bus.getBusNumber().equals(dbBus.getBusNumber())) {
					return "Bus Number already exists";
				}

			}
			return busDAO.doAddBus(operatorId, driverId, seatId, bus);
		} else {
			return busDAO.doAddBus(operatorId, driverId, seatId, bus);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditBus(String operatorId, String driverId, String seatId,
			String busId, Bus updatedBus) {
		List<Bus> busList = busDAO.retrieveBusList();
		for (Bus dbBus : busList) {
			if (dbBus.getBusId() != busId) {
				if (updatedBus.getBusNumber().equals(dbBus.getBusNumber())) {
					return "Bus Number already exists";
				}
			}
		}
		return busDAO
				.doEditBus(operatorId, driverId, seatId, busId, updatedBus);
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteBus(String busId) {
		// TODO Auto-generated method stub
		return busDAO.doDeleteBus(busId);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<Bus> retrieveCityBusList(String cityId) {
		// TODO Auto-generated method stub
		return busDAO.retrieveCityBusList(cityId);
	}

	@Override
	public Bus retrieveBus(String busId) {
		// TODO Auto-generated method stub
		return busDAO.retrieveBus(busId);
	}

	@Override
	public List<Dummy> searchBusesWithDate(List<Bus> busList, String departureDate) {
		// TODO Auto-generated method stub
		return busDAO.searchBusesWithDate(busList, departureDate);
	}

	@Override
	public Dummy retrieveDummy(String busId) {
		// TODO Auto-generated method stub
		return busDAO.retrieveDummy(busId);
	}

	@Override
	public void doReduceSeats(int noOfSeats, Dummy dummy) {
		// TODO Auto-generated method stub
		busDAO.doReduceSeats(noOfSeats, dummy);
		
	}

	@Override
	public int retrieveDriverBus(String driverId) {
		// TODO Auto-generated method stub
		return busDAO.retrieveDriverBus(driverId);
	}

	@Override
	public String doActiveBus(String busId) {
		
		return busDAO.doActiveBus(busId);
	}

}
