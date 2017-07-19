package com.manipal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manipal.model.Bus;
import com.manipal.model.Passenger;

/**
 * Servlet implementation class StorePassengerController
 */
@WebServlet("/StorePassengerController")
public class StorePassengerController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String noOfSeats = (String) session.getAttribute("noOfSeats");
		if(noOfSeats!=null)
		{
		List<Passenger> passengerList = new ArrayList<Passenger>();

		for(int i=0;i<Integer.parseInt(noOfSeats);i++)
		{
			 String passengerFirstname=request.getParameter("passengerFirstName"+i);
			 String passengerLastname=request.getParameter("passengerLastName"+i);
			 String passengerEmail=request.getParameter("passengerEmail"+i);
			 String passengerGender=request.getParameter("passengerGender"+i);
			 int passengerAge=Integer.parseInt(request.getParameter("passengerAge"+i));
			 long passengerContact=Long.parseLong(request.getParameter("passengerContact"+i));
			 
			 Passenger passenger = new Passenger(passengerFirstname, passengerLastname, passengerEmail, passengerGender,passengerAge, passengerContact);
			 passengerList.add(passenger);
			 System.out.println(passengerGender);
		}
		
		session.setAttribute("passengerList", passengerList);
		RequestDispatcher rd = request.getRequestDispatcher("/Payment.jsp");
		rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
			rd.forward(request, response);
		}
		
	}

}
