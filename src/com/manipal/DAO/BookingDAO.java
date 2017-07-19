package com.manipal.DAO;

import java.util.List;

import com.manipal.model.Booking;

public interface BookingDAO 
{
	public String doAddBooking(Booking booking);
	
	public Booking retrieveBooking(String bookingId);
	
	public List<Booking> retrieveBusBooking(String busId);

}
