package com.manipal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manipal.model.Operator;
import com.manipal.service.OperatorService;
import com.manipal.service.impl.OperatorServiceImpl;

@WebServlet("/AddOperatorController")
public class AddOperatorController extends HttpServlet {
	private OperatorService operatorService;
  
	public void init(ServletConfig config) throws ServletException {
		operatorService = new OperatorServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String operatorName = request.getParameter("operatorName");
		String operatorEmail = request.getParameter("operatorEmail");
		String operatorWebsite = request.getParameter("operatorWebsite");
		String operatorFax = request.getParameter("operatorFax");
		String operatorAddress = request.getParameter("operatorAddress");
		Long operatorContact = Long.parseLong(request.getParameter("operatorContact"));
		
		
		Operator operator = new Operator(operatorName,operatorEmail,operatorWebsite,operatorFax,operatorAddress,operatorContact);
		
		session.setAttribute("operator", operator);
		
		String registrationMessage = operatorService.doAddOperator(operator);
		if(registrationMessage.equals("Operator Added Successfully"))
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/Operator.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/Operator.jsp");
			rd.forward(request, response);
		}
		
	}

}
