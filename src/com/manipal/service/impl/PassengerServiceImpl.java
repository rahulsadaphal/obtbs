package com.manipal.service.impl;

import java.util.List;

import com.manipal.DAO.PassengerDAO;
import com.manipal.DAO.jdbc.PassengerDAOImpl;
import com.manipal.model.Passenger;
import com.manipal.service.PassengerService;

public class PassengerServiceImpl implements PassengerService
{
	PassengerDAO passengerDAO;

	public PassengerServiceImpl() {
		passengerDAO = new PassengerDAOImpl();
	}

	public String doAddPassengers(List<Passenger> passengerList,String bookingId) {
		
		return passengerDAO.doAddPassengers(passengerList,bookingId);
	}

	@Override
	public List<Passenger> retrieveBookPassenger(String bookingId) {
		// TODO Auto-generated method stub
		return passengerDAO.retrieveBookPassenger(bookingId);
	}





}
