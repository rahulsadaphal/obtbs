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

import com.manipal.model.Bus;
import com.manipal.model.Driver;
import com.manipal.model.Operator;
import com.manipal.service.BusService;
import com.manipal.service.impl.BusServiceImpl;



@WebServlet("/AddBusController")
public class AddBusController extends HttpServlet {
	private BusService busService;
  
	public void init(ServletConfig config) throws ServletException {
		busService = new BusServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		//String busId= request.getParameter("busId");
		String busNumber= request.getParameter("busNumber");
		String busType= request.getParameter("busType");
		String operatorId = request.getParameter("operatorId");
		String driverId = request.getParameter("driverId");
		
		
		String sourceCity= request.getParameter("sourceCity");
		String destCity= request.getParameter("dest");
		
		String startTime= request.getParameter("startTime");
		String endTime= request.getParameter("endTime");
		String seatId = request.getParameter("seatId");
		
		//String status= request.getParameter("status");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

/*		out.println(busNumber);
		out.println(busType);
		out.println(operatorId);
		out.println(driverId);
		out.println(sourceCity);
		out.println(destCity);
		out.println(startTime);
		out.println(endTime);
		out.println(seatId);*/
		
		
		
		Bus bus = new Bus(busNumber,busType,sourceCity,destCity,startTime,endTime);
		session.setAttribute("bus", bus);
		String registrationMessage = busService.doAddBus(operatorId, driverId, seatId, bus);
		if(registrationMessage.equals("Bus Added Successfully"))
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

