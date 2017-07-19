package com.manipal.model;

import java.util.Date;

public class Transaction 
{
	private String transactionId;
	private String transactionType;
	private Booking booking;
	private Date transactionDate;
	private double transactionAmount;
	
	public Transaction(String transactionType, Booking booking,
			Date transactionDate, double transactionAmount) {
		super();
		this.transactionType = transactionType;
		this.booking = booking;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	
}
