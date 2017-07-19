package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manipal.model.Bus;
import com.manipal.service.BusService;
import com.manipal.service.impl.BusServiceImpl;



@WebServlet("/DeleteBusController")
public class DeleteBusController extends HttpServlet {
	private BusService busService;
	  
	public void init(ServletConfig config) throws ServletException {
		busService = new BusServiceImpl();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String busId = request.getParameter("busid");
		String status = request.getParameter("status");
		
		System.out.println("busId"+busId);
		System.out.println(status);

		Bus bus = busService.retrieveBus(busId);
		session.setAttribute("bus", bus);
		
		
		if(status!=null)
		{
			if(status.equals("Delete"))
			{
				String registrationMessage = busService.doDeleteBus(busId);
				if(registrationMessage.equals("Bus Deleted Successfully"))
				{
					request.setAttribute("Message", registrationMessage);
					RequestDispatcher rd=request.getRequestDispatcher("/Bus.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Message", registrationMessage);
					RequestDispatcher rd=request.getRequestDispatcher("/Bus.jsp");
					rd.forward(request, response);
				}
				
			}
			else
			{
				String registrationMessage = busService.doActiveBus(busId);
				if(registrationMessage.equals("Bus Recovered Successfully"))
				{
				request.setAttribute("Message", registrationMessage);
				RequestDispatcher rd=request.getRequestDispatcher("/Bus.jsp");
				rd.forward(request, response);
				}
				else
				{
				request.setAttribute("Message", registrationMessage);
				RequestDispatcher rd=request.getRequestDispatcher("/Bus.jsp");
				rd.forward(request, response);
				}
			}
		}
		else
		{
		String registrationMessage = busService.doDeleteBus(busId);
		if(registrationMessage.equals("Bus Deleted Successfully"))
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/Bus.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/Bus.jsp");
			rd.forward(request, response);
		}
		}
	}

}
