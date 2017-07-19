package com.manipal.service;

import java.util.List;

import com.manipal.model.*;

public interface PassengerService {
	
	public String doAddPassengers(List<Passenger> passengerList,String bookingId);
	
	public List<Passenger> retrieveBookPassenger(String bookingId); 

}
