package com.manipal.service.impl;

import com.manipal.DAO.PaymentDAO;
import com.manipal.DAO.jdbc.PaymentDAOImpl;
import com.manipal.service.PaymentService;

public class PaymentServiceImpl implements PaymentService{

	PaymentDAO paymentDAO;
	
	public PaymentServiceImpl()
	{
		paymentDAO = new PaymentDAOImpl();
	}
	
	@Override
	public String validateAccount(String cardNumber, String expiry,
			String cvv, double amount) {
		// TODO Auto-generated method stub
		return paymentDAO.validateAccount(cardNumber, expiry, cvv, amount);
	}

	@Override
	public String validateAccount2(String accountNumber, String bank,
			String ifsc, double amount) {
		// TODO Auto-generated method stub
		return paymentDAO.validateAccount(accountNumber, bank, ifsc, amount);
	}

}
