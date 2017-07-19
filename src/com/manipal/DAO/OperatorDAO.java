package com.manipal.DAO;

import java.util.List;

import com.manipal.model.Operator;

public interface OperatorDAO 
{
	public List<Operator> retrieveOperatorList();
	
	public List<Operator> retrieveActiveOperatorList();
	
	public Operator retrieveOperator(String operatorId);
	
	public String doAddOperator(Operator operator);
	
	public String doEditOperator(String operatorId,Operator updatedOperator);
	
	public String doDeleteOperator(String operatorId);
	
	public String doActiveOperator(String operatorId);

}
