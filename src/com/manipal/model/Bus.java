package com.manipal.model;

public class Bus 
{
	private String busId;
	private String busNumber;
	private String busType;
	private Operator operator;
	private Driver driver;
	private String sourceCity;
	private String Destination;
	private String startTime;
	private String endTime;
	private Seat seat;
	private String status;
	
	
	
	public Bus(String busNumber, String busType, String sourceCity,
			String destination, String startTime, String endTime) {
		super();
		this.busNumber = busNumber;
		this.busType = busType;
		this.sourceCity = sourceCity;
		Destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Bus(String busId, String busNumber, String busType,
			Operator operator, Driver driver, String sourceCity,
			String destination, String startTime, String endTime, Seat seat,
			String status) {
		super();
		this.busId = busId;
		this.busNumber = busNumber;
		this.busType = busType;
		this.operator = operator;
		this.driver = driver;
		this.sourceCity = sourceCity;
		Destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seat = seat;
		this.status = status;
	}
	public Bus(){}
	public Bus(String busId, String busNumber, String busType,
			Operator operator, String sourceCity,
			String destination, String startTime, String endTime, Seat seat,
			String status) {
		super();
		this.busId = busId;
		this.busNumber = busNumber;
		this.busType = busType;
		this.operator = operator;
		this.sourceCity = sourceCity;
		Destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seat = seat;
		this.status = status;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
