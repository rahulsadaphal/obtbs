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

@WebServlet("/DeleteOperatorController")
public class DeleteOperatorController extends HttpServlet {
	private OperatorService operatorService;
	  
	public void init(ServletConfig config) throws ServletException {
		operatorService = new OperatorServiceImpl();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String operatorId = request.getParameter("opid");
		String status = request.getParameter("status");
		

		Operator operator = operatorService.retrieveOperator(operatorId);
		session.setAttribute("operator", operator);
/*		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(operatorId);
		out.println(status);*/
		
		if(status!=null)
		{
			if(status.equals("Delete"))
			{
				String registrationMessage = operatorService.doDeleteOperator(operatorId);
				if(registrationMessage.equals("Operator Deleted Successfully"))
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
			else
			{
			String registrationMessage = operatorService.doActiveOperator(operatorId);
			if(registrationMessage.equals("Operator Recovered Successfully"))
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
		else
		{
		String registrationMessage = operatorService.doDeleteOperator(operatorId);
		if(registrationMessage.equals("Operator Deleted Successfully"))
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

}
