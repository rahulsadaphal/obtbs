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

import com.manipal.model.User;
import com.manipal.service.UserService;
import com.manipal.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private UserService userService;

	public void init(ServletConfig config) throws ServletException {
		userService = new UserServiceImpl();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userUsername = request.getParameter("userUsername");
		String userPassword = request.getParameter("userPassword");
		String userFirstname = request.getParameter("userFirstname");
		String userLastname = request.getParameter("userLastname");
		String userEmail = request.getParameter("userEmail");
		String userGender = request.getParameter("userGender");
		Long userContact = Long.parseLong(request.getParameter("userContact"));

		User user = new User(userUsername, userPassword, userFirstname,
				userLastname, userEmail, userGender, userContact);

		String registrationMessage = userService.doAddUser(user);
		if(registrationMessage.equals("Account created successfully"))
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("Message", registrationMessage);
			RequestDispatcher rd=request.getRequestDispatcher("/Registration.jsp");
			rd.forward(request, response);
		}
		


	}

}
