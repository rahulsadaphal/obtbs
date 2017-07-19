package com.manipal.model;

import java.util.Date;

public class Dummy 
{
	private String busId;
	private String startTime;
	private String endTime;
	private String departureDate;
	private int remainSeats;
	public Dummy(String busId, String startTime, String endTime,
			String departureDate, int remainSeats) {
		super();
		this.busId = busId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.departureDate = departureDate;
		this.remainSeats = remainSeats;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getRemainSeats() {
		return remainSeats;
	}
	public void setRemainSeats(int remainSeats) {
		this.remainSeats = remainSeats;
	}
	
	

}
