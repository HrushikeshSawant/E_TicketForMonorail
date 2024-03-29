package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		System.out.println("user: " + user);
		session.removeAttribute("Email");
		session.removeAttribute("Name");
		session.removeAttribute("Wallet");
		session.removeAttribute("Amount");
		session.removeAttribute("getStationNames");
		session.removeAttribute("Source");
		session.removeAttribute("Destination");
		session.removeAttribute("PassengersCount");
		session.removeAttribute("FromDate");
		session.removeAttribute("ThroughDate");
		session.removeAttribute("Type");
		session.removeAttribute("Fare");
		session.removeAttribute("txnid");
		session.removeAttribute("dateTime");
		session.invalidate();
		request.setAttribute("Message", "Successfully Logout.");
		if(user.equalsIgnoreCase("admin"))
		{
			request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
