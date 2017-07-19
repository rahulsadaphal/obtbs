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

import com.manipal.model.City;
import com.manipal.service.CityService;
import com.manipal.service.impl.CityServiceImpl;

/**
 * Servlet implementation class DeleteCityController
 */
@WebServlet("/DeleteCityController")
public class DeleteCityController extends HttpServlet {
	private CityService cityService;
	  
	public void init(ServletConfig config) throws ServletException {
		cityService = new CityServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String cityId = request.getParameter("cityid");
		String status = request.getParameter("status");
		
		City city = cityService.retrieveCity(cityId);
		session.setAttribute("city", city);
		
/*		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(cityId);
		out.println(status);*/
		if(status!=null)
		{
			if(status.equals("Delete"))
			{
				String registrationMessage = cityService.doDeleteCity(cityId);
				if(registrationMessage.equals("City Deleted Successfully"))
				{
					request.setAttribute("Message", registrationMessage);
					RequestDispatcher rd=request.getRequestDispatcher("/City.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Message", registrationMessage);
					RequestDispatcher rd=request.getRequestDispatcher("/City.jsp");
					rd.forward(request, response);
				}
				
			}
			else
			{
			String registrationMessage = cityService.doActiveCity(cityId);
			if(registrationMessage.equals("City Recovered Successfully"))
			{
				request.setAttribute("Message", registrationMessage);
				RequestDispatcher rd=request.getRequestDispatcher("/City.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Message", registrationMessage);
				RequestDispatcher rd=request.getRequestDispatcher("/City.jsp");
				rd.forward(request, response);
			}
			}
		}
		else
		{
		String registrationMessage = cityService.doDeleteCity(cityId);
		if(registrationMessage.equals("City Deleted Successfully"))
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/City.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/City.jsp");
			rd.forward(request, response);
		}
		}
	}

}
