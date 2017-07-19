package com.manipal.DAO;

import java.util.List;

import com.manipal.model.Passenger;

public interface PassengerDAO {
	
	public String doAddPassengers(List<Passenger> passengerList,String bookingId);

	public List<Passenger> retrieveBookPassenger(String bookingId);

}
