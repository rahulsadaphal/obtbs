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

import com.manipal.service.UserService;
import com.manipal.service.impl.UserServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private UserService userService;

	public void init(ServletConfig config) throws ServletException {
		userService = new UserServiceImpl();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userUsername = request.getParameter("userUsername");
		String userPassword = request.getParameter("userPassword");
		String userType = request.getParameter("userType");

		HttpSession session = request.getSession(true);

		if (userType.equals("Admin")) {
			if ((userUsername.equals("admin") && userPassword.equals("admin"))
					|| (userUsername.equals("atosadmin") && userPassword.equals("atosadmin")))
			{
				session.setAttribute("uname", "Administrator");
				RequestDispatcher rd = request.getRequestDispatcher("/AdminHome.jsp");
				rd.forward(request, response);
			}
			else
			{
				String errorMessage="You have entered wrong username & password";
				request.setAttribute("Message", errorMessage);
				RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
			}
		} 
		else 
		{
			if(userService.loginValidate(userUsername, userPassword) == 1)
			{
				String fullName = userService.getFullName(userUsername);
				session.setAttribute("uname", fullName);
				RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("username", "");
				String errorMessage="You have entered wrong username & password";
				request.setAttribute("Message", errorMessage);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
			

		}

	}

}
