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

import com.manipal.model.Driver;
import com.manipal.service.DriverService;
import com.manipal.service.impl.DriverServiceImpl;

@WebServlet("/DeleteDriverController")
public class DeleteDriverController extends HttpServlet {
	private DriverService driverService;
	  
	public void init(ServletConfig config) throws ServletException {
		driverService = new DriverServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession(false);
		
		String driverId = request.getParameter("driverid");
		String status = request.getParameter("status");
		

		Driver driver = driverService.retrieveDriver(driverId);
		session.setAttribute("driver", driver);
/*		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(operatorId);
		out.println(status);*/
		
		if(status!=null)
		{
			if(status.equals("Delete"))
			{
				String registrationMessage = driverService.doDeleteDriver(driverId);
				if(registrationMessage.equals("Driver Deleted Successfully"))
				{
					request.setAttribute("Message", registrationMessage);
					RequestDispatcher rd=request.getRequestDispatcher("/Driver.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Message", registrationMessage);
					RequestDispatcher rd=request.getRequestDispatcher("/Driver.jsp");
					rd.forward(request, response);
				}
				
			}
			else
			{
			String registrationMessage = driverService.doActiveDriver(driverId);
			if(registrationMessage.equals("Driver Recovered Successfully"))
			{
				request.setAttribute("Message", registrationMessage);
				RequestDispatcher rd=request.getRequestDispatcher("/Driver.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Message", registrationMessage);
				RequestDispatcher rd=request.getRequestDispatcher("/Driver.jsp");
				rd.forward(request, response);
			}
			}
		}
		else
		{
				String registrationMessage = driverService.doDeleteDriver(driverId);
					if(registrationMessage.equals("Driver Deleted Successfully"))
					{
						request.setAttribute("Message", registrationMessage);
						RequestDispatcher rd=request.getRequestDispatcher("/Driver.jsp");
						rd.forward(request, response);
					}
					else
					{
						request.setAttribute("Message", registrationMessage);
						RequestDispatcher rd=request.getRequestDispatcher("/Driver.jsp");
						rd.forward(request, response);
					}
		}
	}


}
