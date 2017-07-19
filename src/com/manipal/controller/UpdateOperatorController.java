package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class UpdateOperatorController
 */
@WebServlet("/UpdateOperatorController")
public class UpdateOperatorController extends HttpServlet {
	private OperatorService operatorService;
	  
	public void init(ServletConfig config) throws ServletException {
		operatorService = new OperatorServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); 
		
		String operatorId = request.getParameter("opid");
		String operatorName = request.getParameter("operatorName");
		String operatorEmail = request.getParameter("operatorEmail");
		String operatorWebsite = request.getParameter("operatorWebsite");
		String operatorFax = request.getParameter("operatorFax");
		String operatorAddress = request.getParameter("operatorAddress");
		Long operatorContact = Long.parseLong(request.getParameter("operatorContact"));
		String status = request.getParameter("opstatus");
	/*	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(status);
		out.println(operatorId);
		out.println(operatorName);
		out.println(operatorEmail);
		out.println(operatorWebsite);
		out.println(operatorFax);
		out.println(operatorAddress);
		out.println(operatorContact);*/
		
		
		Operator updatedOperator = new Operator(operatorName,operatorEmail,operatorWebsite,operatorFax,operatorAddress,operatorContact,status);
		session.setAttribute("operator", updatedOperator);
		
		String registrationMessage = operatorService.doEditOperator(operatorId, updatedOperator);
		if(registrationMessage.equals("Operator updated Successfully"))
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
