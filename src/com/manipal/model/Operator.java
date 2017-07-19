package com.manipal.model;

public class Operator 
{
	private String operatorId;
	private String operatorName;
	private String operatorEmail;
	private String operatorWebsite;
	private String operatorFaxNumber;
	private String operatorAddress;
	private long operatorContact;
	private String status;
	

	public Operator(){}

	
	public Operator(String operatorName, String operatorEmail,
			String operatorWebsite, String operatorFaxNumber,
			String operatorAddress, long operatorContact, String status) {
		super();
		this.operatorName = operatorName;
		this.operatorEmail = operatorEmail;
		this.operatorWebsite = operatorWebsite;
		this.operatorFaxNumber = operatorFaxNumber;
		this.operatorAddress = operatorAddress;
		this.operatorContact = operatorContact;
		this.status = status;
	}


	public Operator(String operatorName, String operatorEmail,
			String operatorWebsite, String operatorFaxNumber,
			String operatorAddress, long operatorContact) {
		super();
		this.operatorName = operatorName;
		this.operatorEmail = operatorEmail;
		this.operatorWebsite = operatorWebsite;
		this.operatorFaxNumber = operatorFaxNumber;
		this.operatorAddress = operatorAddress;
		this.operatorContact = operatorContact;
	}

	public Operator(String operatorId, String operatorName,
			String operatorEmail, String operatorWebsite,
			String operatorFaxNumber, String operatorAddress,
			long operatorContact, String status) {
		super();
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.operatorEmail = operatorEmail;
		this.operatorWebsite = operatorWebsite;
		this.operatorFaxNumber = operatorFaxNumber;
		this.operatorAddress = operatorAddress;
		this.operatorContact = operatorContact;
		this.status = status;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorEmail() {
		return operatorEmail;
	}

	public void setOperatorEmail(String operatorEmail) {
		this.operatorEmail = operatorEmail;
	}

	public String getOperatorWebsite() {
		return operatorWebsite;
	}

	public void setOperatorWebsite(String operatorWebsite) {
		this.operatorWebsite = operatorWebsite;
	}

	public String getOperatorFaxNumber() {
		return operatorFaxNumber;
	}

	public void setOperatorFaxNumber(String operatorFaxNumber) {
		this.operatorFaxNumber = operatorFaxNumber;
	}

	public String getOperatorAddress() {
		return operatorAddress;
	}

	public void setOperatorAddress(String operatorAddress) {
		this.operatorAddress = operatorAddress;
	}

	public long getOperatorContact() {
		return operatorContact;
	}

	public void setOperatorContact(long operatorContact) {
		this.operatorContact = operatorContact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
