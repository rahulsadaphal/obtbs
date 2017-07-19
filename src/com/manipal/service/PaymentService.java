package com.manipal.service;

public interface PaymentService 
{
	public String validateAccount(String cardNumber,String expiry,String cvv,double amount);
	
	public String validateAccount2(String accountNumber,String bank,String ifsc,double amount);

}
