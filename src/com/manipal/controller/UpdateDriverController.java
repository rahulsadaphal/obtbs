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

	import com.manipal.model.Driver;
	import com.manipal.service.DriverService;
	import com.manipal.service.impl.DriverServiceImpl;

	/**
	 * Servlet implementation class UpdateDriverController
	 */
	@WebServlet("/UpdateDriverController")


	public class UpdateDriverController extends HttpServlet {
		private DriverService driverService;
		  
		public void init(ServletConfig config) throws ServletException {
			driverService = new DriverServiceImpl();
		}

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String driverId = request.getParameter("did");
			String driverName = request.getParameter("driverName");
			String driverEmail = request.getParameter("driverEmail");
			String driverAddress = request.getParameter("driverAddress");
			String driverLicenceNumber = request.getParameter("driverLicenceNumber");
			
			Long driverContact = Long.parseLong(request.getParameter("driverContact"));
			String status = request.getParameter("dstatus");
		/*	
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println(status);
			out.println(driverId);
			out.println(driverName);
			out.println(driverEmail);
			out.println(driverAddress);
			out.println(driverLicenceNumber);
			out.println(driverAddress);
			*/
			
			HttpSession session = request.getSession();
			Driver updatedDriver = new Driver(driverName,driverEmail,driverAddress,driverLicenceNumber,driverContact,status);
			
			String registrationMessage = driverService.doEditDriver(driverId, updatedDriver);
			if(registrationMessage.equals("Driver updated Successfully"))
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

	
	

