package com.manipal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
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
import com.manipal.model.City;
import com.manipal.model.Dummy;
import com.manipal.service.BusService;
import com.manipal.service.CityService;
import com.manipal.service.impl.BusServiceImpl;
import com.manipal.service.impl.CityServiceImpl;

@WebServlet("/SearchBusController")
public class SearchBusController extends HttpServlet 
{
	private BusService busService;
	private CityService cityService;
	private HttpSession session=null;
	
	public void init(ServletConfig config) throws ServletException {
		busService = new BusServiceImpl();
		cityService = new CityServiceImpl();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		session = request.getSession();
		
		
		String name = (String)session.getAttribute("uname");
		
		
		System.out.println("Search : "+name);
		
		if(name.equals("Passenger"))
		{
			session = request.getSession(true);
			String source = request.getParameter("fromcity");
			String dest = request.getParameter("tocity");
			String date = request.getParameter("onboarddate");
			
			System.out.println(date);
			City c1 = cityService.retrieveCityByName(source);
			City c2 = cityService.retrieveCityByName(dest);
			
			System.out.println("source:"+c1.getCityId());
			System.out.println("dest:"+c2.getCityId());
			List<Bus> busList = new BusServiceImpl().searchBuses(c1.getCityId(), c2.getCityId());
			
			System.out.println("available bus : "+busList.size());

			if(busList!=null)
			{
			if(busList.size()!=0)
			{
				List<Dummy> dummyList =busService.searchBusesWithDate(busList, date);
				System.out.println("Bus dummy Size"+dummyList.size());

				session.setAttribute("busList", dummyList);
				RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("emptyList", "There is no Bus Available");
				RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
				rd.forward(request, response);
			}
			}
			else
			{
				System.out.println("no buses");
			}
			
		}
		else
		{
			session = request.getSession(false); 
			String source = request.getParameter("fromcity");
			String dest = request.getParameter("tocity");
			String date = request.getParameter("onboarddate");
			
			City c1 = cityService.retrieveCityByName(source);
			City c2 = cityService.retrieveCityByName(dest);
			
			List<Bus> busList = busService.searchBuses(c1.getCityId(), c2.getCityId());
			if(busList.size()!=0)
			{
				List<Dummy> dummyList =busService.searchBusesWithDate(busList, date);

				session.setAttribute("busList", dummyList);
				RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("emptyList", "There is no Bus Available");
				RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
			}
			
		}
		

		
		
	}

}
