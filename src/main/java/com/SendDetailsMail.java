package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import other.sendEmail;


/**
 * Servlet implementation class SendDetailsMail
 */
public class SendDetailsMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(SendDetailsMail.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String type = request.getParameter("type");
		String userType = request.getParameter("user-type");
		double passengersCount = 0;
		String validFrom = null;
		String validThrough = null;
		String passType = null;
		String name = null;
		String email = null;
		String source = (String)session.getAttribute("Source");
		String destination = (String)session.getAttribute("Destination");
		
		//===FOR USER TYPE===//
		if(userType.equalsIgnoreCase("user"))
		{
			name = (String)session.getAttribute("Name");
			email = (String)session.getAttribute("Email");
		}
		
		//===FOR USER TYPE===//
		if(userType.equalsIgnoreCase("admin"))
			email = (String)session.getAttribute("UserEmail");
			
		//===FOR TICKET===//
		if(type.equalsIgnoreCase("ticket"))
			passengersCount = (Double)session.getAttribute("PassengersCount");
		
		//===FOR PASS===//
		if(type.equalsIgnoreCase("pass"))
		{
			validFrom = (String)session.getAttribute("FromDate");
			validThrough = (String)session.getAttribute("ThroughDate");
			passType = (String)session.getAttribute("Type");
		}
		
		double fare = (Double)session.getAttribute("Fare");
		String txnid = (String)session.getAttribute("txnid");
		String dateTime = (String)session.getAttribute("dateTime");
		String result = null;
		
		if(type.equalsIgnoreCase("ticket"))
		{
			if(userType.equalsIgnoreCase("user"))
				result = sendEmail.sendTicketDetailsToUser(name, email, source, destination, passengersCount, fare, txnid, dateTime);
			else if(userType.equalsIgnoreCase("admin"))
				result = sendEmail.sendTicketFromAdminDetailsToUser(email, source, destination, passengersCount, fare, txnid, dateTime);
			
			if(result.equalsIgnoreCase("Email Sent"))
			{
				session.removeAttribute("Source");
				session.removeAttribute("Destination");
				session.removeAttribute("PassengersCount");
				session.removeAttribute("Fare");
				session.removeAttribute("txnid");
				session.removeAttribute("dateTime");
				session.removeAttribute("getStationNames");
				
				if(userType.equalsIgnoreCase("user"))
				{
					response.sendRedirect("welcome.jsp");
				}
				else if(userType.equalsIgnoreCase("admin"))
				{
					session.removeAttribute("UserEmail");
					response.sendRedirect("admin-welcome.jsp");
				}
			}
			else
			{
				request.setAttribute("Error", "Email not sent, Something went wrong, Please try again..");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
		else if(type.equalsIgnoreCase("pass"))
		{
			result = sendEmail.sendPassDetailsToUser(name, email, source, destination, validFrom, validThrough, passType, fare, txnid, dateTime);
			if(result.equalsIgnoreCase("Email Sent"))
			{
				session.removeAttribute("Source");
				session.removeAttribute("Destination");
				session.removeAttribute("FromDate");
				session.removeAttribute("ThroughDate");
				session.removeAttribute("Type");
				session.removeAttribute("Fare");
				session.removeAttribute("txnid");
				session.removeAttribute("dateTime");
				session.removeAttribute("getStationNames");
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				request.setAttribute("Error", "Email not sent, Something went wrong, Please try again..");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
	}

}
