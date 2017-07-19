package com.manipal.model;

import java.util.Date;

public class Cancelletion 
{
	private String cancelletionId;
	private Date cancelletionDate;
	private double cancelletionCharge;
	private double refundAmount;
	private Booking booking;
	public Cancelletion(Date cancelletionDate, double cancelletionCharge,
			double refundAmount, Booking booking) {
		super();
		this.cancelletionDate = cancelletionDate;
		this.cancelletionCharge = cancelletionCharge;
		this.refundAmount = refundAmount;
		this.booking = booking;
	}
	public String getCancelletionId() {
		return cancelletionId;
	}
	public void setCancelletionId(String cancelletionId) {
		this.cancelletionId = cancelletionId;
	}
	public Date getCancelletionDate() {
		return cancelletionDate;
	}
	public void setCancelletionDate(Date cancelletionDate) {
		this.cancelletionDate = cancelletionDate;
	}
	public double getCancelletionCharge() {
		return cancelletionCharge;
	}
	public void setCancelletionCharge(double cancelletionCharge) {
		this.cancelletionCharge = cancelletionCharge;
	}
	public double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	

}
