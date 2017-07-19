package com.manipal.model;

public class Passenger 
{
	private String passengerId;
	private String passengerFirstname;
	private String passengerLastname;
	private String passengerEmail;
	private String passengerGender;
	private Booking booking;
	private int passengerAge;
	private long passengerContact;
	
	
	
	public Passenger(String passengerFirstname,
			String passengerLastname, String passengerEmail,
			String passengerGender, int passengerAge, long passengerContact) {
		super();
		this.passengerFirstname = passengerFirstname;
		this.passengerLastname = passengerLastname;
		this.passengerEmail = passengerEmail;
		this.passengerGender = passengerGender;
		this.passengerAge = passengerAge;
		this.passengerContact = passengerContact;
	}
	public Passenger(String passengerId,String passengerFirstname, String passengerLastname,
			String passengerEmail, String passengerGender,
			int passengerAge, long passengerContact) {
		super();
		this.passengerId = passengerId;
		this.passengerFirstname = passengerFirstname;
		this.passengerLastname = passengerLastname;
		this.passengerEmail = passengerEmail;
		this.passengerGender = passengerGender;
		this.passengerAge = passengerAge;
		this.passengerContact = passengerContact;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerFirstname() {
		return passengerFirstname;
	}
	public void setPassengerFirstname(String passengerFirstname) {
		this.passengerFirstname = passengerFirstname;
	}
	public String getPassengerLastname() {
		return passengerLastname;
	}
	public void setPassengerLastname(String passengerLastname) {
		this.passengerLastname = passengerLastname;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public long getPassengerContact() {
		return passengerContact;
	}
	public void setPassengerContact(long passengerContact) {
		this.passengerContact = passengerContact;
	}
	
	

}
