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
 * Servlet implementation class UpdateCityController
 */
@WebServlet("/UpdateCityController")
public class UpdateCityController extends HttpServlet {
private CityService cityService;
	
	public void init(ServletConfig config) throws ServletException {
		cityService = new CityServiceImpl();
	}
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String cityId = request.getParameter("cityid");
		String cityName = request.getParameter("cityName");
		String cityState = request.getParameter("cityState");
		String status = request.getParameter("cityStatus");
		
		
/*		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(status);
		out.println(cityId);
		out.println(cityName);
		out.println(cityState);*/
		
		City updatedCity = new City(cityName,cityState,status);
		session.setAttribute("city", updatedCity);
		
		String registrationMessage = cityService.doEditCity(cityId, updatedCity);
		if(registrationMessage.equals("City updated Successfully"))
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
