package com.manipal.model;

public class Driver 
{
	private String driverId;
	private String driverName;
	private String driverEmail;
	private String driverAddress;
	private String driverLicenceNumber;
	private long driverContact;
	private String status;
	
	public Driver(){}
	
	public Driver(String driverId, String driverName, String driverEmail,
			String driverAddress, String driverLicenceNumber,
			long driverContact, String status) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverEmail = driverEmail;
		this.driverAddress = driverAddress;
		this.driverLicenceNumber = driverLicenceNumber;
		this.driverContact = driverContact;
		this.status = status;
	}

	public Driver(String driverName, String driverEmail, String driverAddress,
			String driverLicenceNumber, long driverContact, String status) {
		super();
		this.driverName = driverName;
		this.driverEmail = driverEmail;
		this.driverAddress = driverAddress;
		this.driverLicenceNumber = driverLicenceNumber;
		this.driverContact = driverContact;
		this.status = status;
	}

	public Driver(String driverName, String driverEmail, String driverAddress,
			String driverLicenceNumber, long driverContact) {
		super();
		this.driverName = driverName;
		this.driverEmail = driverEmail;
		this.driverAddress = driverAddress;
		this.driverLicenceNumber = driverLicenceNumber;
		this.driverContact = driverContact;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverEmail() {
		return driverEmail;
	}
	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}
	public String getDriverAddress() {
		return driverAddress;
	}
	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}
	public String getDriverLicenceNumber() {
		return driverLicenceNumber;
	}
	public void setDriverLicenceNumber(String driverLicenceNumber) {
		this.driverLicenceNumber = driverLicenceNumber;
	}
	public long getDriverContact() {
		return driverContact;
	}
	public void setDriverContact(long driverContact) {
		this.driverContact = driverContact;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
