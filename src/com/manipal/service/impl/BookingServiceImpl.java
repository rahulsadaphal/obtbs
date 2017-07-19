package com.manipal.service.impl;

import java.util.List;

import com.manipal.DAO.BookingDAO;
import com.manipal.DAO.jdbc.BookingDAOImpl;
import com.manipal.model.Booking;
import com.manipal.service.BookingService;

public class BookingServiceImpl implements BookingService{
	BookingDAO bookingDAO;
	
	
	public BookingServiceImpl()
	{
		bookingDAO = new BookingDAOImpl();
	}
	@Override
	public String doAddBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDAO.doAddBooking(booking);
	}
	@Override
	public Booking retrieveBooking(String bookingId) {
		// TODO Auto-generated method stub
		return bookingDAO.retrieveBooking(bookingId);
	}
	@Override
	public List<Booking> retrieveBusBooking(String busId) {
		// TODO Auto-generated method stub
		return bookingDAO.retrieveBusBooking(busId);
	}

}
