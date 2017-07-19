package com.manipal.service.impl;

import java.util.List;

import com.manipal.DAO.OperatorDAO;
import com.manipal.DAO.jdbc.OperatorDAOImpl;
import com.manipal.model.Bus;
import com.manipal.model.Operator;
import com.manipal.service.OperatorService;

public class OperatorServiceImpl implements OperatorService {
	OperatorDAO operatorDAO;

	public OperatorServiceImpl() {
		operatorDAO = new OperatorDAOImpl();
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Operator> retrieveOperatorList() {
		// TODO Auto-generated method stub
		return operatorDAO.retrieveOperatorList();
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public List<Operator> retrieveActiveOperatorList() {
		// TODO Auto-generated method stub
		return operatorDAO.retrieveActiveOperatorList();
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public Operator retrieveOperator(String operatorId) {
		// TODO Auto-generated method stub
		return operatorDAO.retrieveOperator(operatorId);
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddOperator(Operator operator) {
		List<Operator> operatorList = operatorDAO.retrieveOperatorList();
		if (operatorList.size() != 0) {
			for (Operator dbOperator : operatorList) {
				if (operator.getOperatorEmail().equals(
						dbOperator.getOperatorEmail())) {
					return "Email Address already exists";
				} else if (operator.getOperatorWebsite().equals(
						dbOperator.getOperatorWebsite())) {
					return "Website already exists";
				} else if (operator.getOperatorContact() == dbOperator
						.getOperatorContact()) {
					return "This contact Number already used";
				} else if (operator.getOperatorFaxNumber().equals(
						dbOperator.getOperatorFaxNumber())) {
					return "This Fax Number already used";
				}
			}
			return operatorDAO.doAddOperator(operator);
		} else {
			return operatorDAO.doAddOperator(operator);
		}
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditOperator(String operatorId, Operator updatedOperator) {
		System.out.println("operatorId"+operatorId);
		List<Operator> operatorList = operatorDAO.retrieveOperatorList();
		for (Operator dbOperator : operatorList) 
		{
			if (!(dbOperator.getOperatorId().equals(operatorId))) 
			{
				System.out.println(dbOperator.getOperatorId());
				if (updatedOperator.getOperatorEmail().equals(
						dbOperator.getOperatorEmail())) {
					return "Email Address already exists";
				} else if (updatedOperator.getOperatorWebsite().equals(
						dbOperator.getOperatorWebsite())) {
					return "Website already exists";
				} else if (updatedOperator.getOperatorContact() == dbOperator
						.getOperatorContact()) {
					return "This contact Number already used";
				} else if (updatedOperator.getOperatorFaxNumber().equals(
						dbOperator.getOperatorFaxNumber())) {
					return "This Fax Number already used";
				}
			}
		}
		return operatorDAO.doEditOperator(operatorId, updatedOperator);
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteOperator(String operatorId) {
		List<Bus> operatorBusList = new BusServiceImpl().retrieveOperatorBusList(operatorId);
		if(operatorBusList.size()==0)
		{
			return operatorDAO.doDeleteOperator(operatorId);
		}
		else
		{
			return "Operator provides "+operatorBusList.size()+" Bus";
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doActiveOperator(String operatorId) {
		// TODO Auto-generated method stub
		return operatorDAO.doActiveOperator(operatorId);
	}

}
