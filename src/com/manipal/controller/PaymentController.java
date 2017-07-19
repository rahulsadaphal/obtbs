package com.manipal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manipal.model.Booking;
import com.manipal.model.Bus;
import com.manipal.model.Dummy;
import com.manipal.model.Passenger;
import com.manipal.service.PaymentService;
import com.manipal.service.impl.BookingServiceImpl;
import com.manipal.service.impl.BusServiceImpl;
import com.manipal.service.impl.PassengerServiceImpl;
import com.manipal.service.impl.PaymentServiceImpl;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
private PaymentService paymentService;
	
	public void init(ServletConfig config) throws ServletException {
		paymentService = new PaymentServiceImpl();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		Bus bus = (Bus) session.getAttribute("bus");
		if(bus!=null)
		{
			String noOfSeats = (String) session.getAttribute("noOfSeats");
			Dummy dummy = (Dummy) session.getAttribute("dummy");
			List<Passenger> passengerList = (List<Passenger>) session.getAttribute("passengerList");
			Double amount = (Double)session.getAttribute("total");

		String paymentMode = request.getParameter("paymentMode");
		System.out.println(paymentMode);
		if(paymentMode!=null)
		{
			if(paymentMode.equals("Card Payment"))
			{
				String cardNumber =request.getParameter("cardNumber");
				String cardHolderName = request.getParameter("cardHolderName");
				String expiry = request.getParameter("month")+"-"+request.getParameter("year");
				String cvv = request.getParameter("cvv");
				
				
				String paymentMessage = paymentService.validateAccount(cardNumber,expiry,cvv,amount);
				if(paymentMessage.equals("Payment Done Successfully"))
				{
					Booking booking = new Booking(dummy,Integer.parseInt(noOfSeats));
					String id = new BookingServiceImpl().doAddBooking(booking);
					
					String passengerDetails = new PassengerServiceImpl().doAddPassengers(passengerList, id);
					
					
					
					new BusServiceImpl().doReduceSeats(Integer.parseInt(noOfSeats),dummy);
					
					request.setAttribute("Message", paymentMessage);
					request.setAttribute("bookingId", id);
					request.setAttribute("total", amount);
					RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Message", paymentMessage);
					RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				System.out.println("In netbanking");
				String accountNumber =request.getParameter("accountNumber");
				String accountHolderName = request.getParameter("accountHolderName");
				String bank = request.getParameter("bank");
				String ifscCode = request.getParameter("ifscCode");
				
				String paymentMessage = paymentService.validateAccount2(accountNumber,bank,ifscCode,amount);
				if(paymentMessage.equals("Payment Done Successfully"))
				{
					Booking booking = new Booking(dummy,Integer.parseInt(noOfSeats));
					String id = new BookingServiceImpl().doAddBooking(booking);
					String passengerDetails = new PassengerServiceImpl().doAddPassengers(passengerList, id);
					new BusServiceImpl().doReduceSeats(Integer.parseInt(noOfSeats),dummy);
					request.setAttribute("Message", paymentMessage);
					request.setAttribute("bookingId", id);
					RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
				}
				else
				{
					request.setAttribute("Message", paymentMessage);
					RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
					rd.forward(request, response);
				}
			}
		}
		}
		
		else
		{
			session.invalidate();
			RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		
		}
	}
}
