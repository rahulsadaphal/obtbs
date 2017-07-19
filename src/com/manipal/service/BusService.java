package com.manipal.service;

import java.sql.Date;
import java.util.List;

import com.manipal.model.Bus;
import com.manipal.model.Dummy;

public interface BusService 
{
	public List<Bus> searchBuses(String source,String Destination);
	
	public List<Dummy> searchBusesWithDate(List<Bus> busList,String departureDate);
	
	public List<Bus> retrieveActiveBusList();
	
	public void doReduceSeats(int noOfSeats,Dummy dummy);
	
	public List<Bus> retrieveBusList();
	
	public Bus retrieveBus(String busId);
	
	public int retrieveDriverBus(String driverId);
	
	public Dummy retrieveDummy(String busId);
	
	public List<Bus> retrieveOperatorBusList(String operatorId);
	
	public List<Bus> retrieveCityBusList(String cityId);
	
	public String doAddBus(String operatorId,String driverId,String seatId,Bus bus);
	
	public String doEditBus(String operatorId,String driverId,String seatId,String busId,Bus updatedBus);
	
	public String doDeleteBus(String busId);
	
	public String doActiveBus(String busId);

}
