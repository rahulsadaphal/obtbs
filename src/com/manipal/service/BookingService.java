package com.manipal.service;

import java.util.List;

import com.manipal.model.Booking;

public interface BookingService 
{
	public String doAddBooking(Booking booking);
	
	public Booking retrieveBooking(String bookingId);
	
	public List<Booking> retrieveBusBooking(String busId);

}
