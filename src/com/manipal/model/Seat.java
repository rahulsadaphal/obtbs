package com.manipal.model;

public class Seat 
{
	private String seatId;
	private String seatType;
	private int numberOfSeats;
	private double fare;
	

	public Seat(){}
	
	public Seat(String seatType, int numberOfSeats, double fare) {
		super();
		this.seatType = seatType;
		this.numberOfSeats = numberOfSeats;
		this.fare = fare;
	}

	public Seat(String seatId, String seatType, int numberOfSeats, double fare) {
		super();
		this.seatId = seatId;
		this.seatType = seatType;
		this.numberOfSeats = numberOfSeats;
		this.fare = fare;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	

}
