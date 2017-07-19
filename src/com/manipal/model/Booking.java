package com.manipal.model;

import java.util.Date;

public class Booking 
{
	private String bookingId;
	private Dummy dummy;
	private Date bookingDate;
	private int numberOfSeatsBooked;
	
	
	
	public Booking(String bookingId, Dummy dummy, Date bookingDate,
			int numberOfSeatsBooked) {
		super();
		this.bookingId = bookingId;
		this.dummy = dummy;
		this.bookingDate = bookingDate;
		this.numberOfSeatsBooked = numberOfSeatsBooked;
	}
	public Booking(Dummy dummy, int noOfSeats) {
		this.dummy = dummy;
		this.numberOfSeatsBooked = noOfSeats;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Dummy getDummy() {
		return dummy;
	}
	public void setDummy(Dummy dummy) {
		this.dummy = dummy;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getNumberOfSeatsBooked() {
		return numberOfSeatsBooked;
	}
	public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
		this.numberOfSeatsBooked = numberOfSeatsBooked;
	}
	
	
	
	

}
