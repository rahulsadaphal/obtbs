package com.manipal.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manipal.service.CityService;
import com.manipal.service.impl.CityServiceImpl;

/**
 * Servlet implementation class BookSeatController
 */
@WebServlet("/BookSeatController")
public class BookSeatController extends HttpServlet {

	
	public void init(ServletConfig config) throws ServletException {
		
	}	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = request.getParameter("pMode");
		System.out.println("payment : "+mode);
	}

}
