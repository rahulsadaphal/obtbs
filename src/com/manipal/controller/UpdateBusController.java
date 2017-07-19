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
import com.manipal.model.Seat;
import com.manipal.service.BusService;
import com.manipal.service.impl.BusServiceImpl;

/**
 * Servlet implementation class UpdateOperatorController
 */
@WebServlet("/UpdateBusController")
public class UpdateBusController extends HttpServlet {
	private BusService busService;
	  
	public void init(ServletConfig config) throws ServletException {
		busService = new BusServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busId= request.getParameter("busId");
		String busNumber= request.getParameter("busNumber");
		String busType= request.getParameter("busType");
		//String operator= request.getParameter("operatorId");
		//String driver= request.getParameter("driverId");
		String sourceCity= request.getParameter("sourceCity");
		String destCity= request.getParameter(" Destination");
		
		Operator op = new Operator();
		String opid = op.getOperatorId();
		
		Driver dr = new Driver();
		String drid = dr.getDriverId();
		
		Seat st = new Seat();
		String seat = st.getSeatId();
		
		String startTime= request.getParameter("startTime");
		String endTime= request.getParameter("endTime");
		//String seatId= request.getParameter("seatId");
		String status= request.getParameter("status");
	
		/*PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(status);
		out.println(busId);
		out.println(busNumber);
		out.println(busType);
		out.println(opid);
		out.println(drid);
		out.println(sourceCity);
		out.println(Destination);
		out.println(startTime);
		out.println(endTime);
		out.println(seat);
		out.println(status);
		*/
		
		HttpSession session = request.getSession();
		Bus bus = new Bus(busNumber,busType,sourceCity,destCity,startTime,endTime);
		String registrationMessage =busService.doEditBus(opid, drid, seat, busId, bus);
		if(registrationMessage.equals("Busupdated Successfully"))
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
