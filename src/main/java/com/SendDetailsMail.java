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
		String name = (String)session.getAttribute("Name");
		String email = (String)session.getAttribute("Email");
		String source = (String)session.getAttribute("Source");
		String destination = (String)session.getAttribute("Destination");
		double passengersCount = (Double)session.getAttribute("PassengersCount");
		double fare = (Double)session.getAttribute("Fare");
		String txnid = (String)session.getAttribute("txnid");
		String dateTime = (String)session.getAttribute("dateTime");
		String type = request.getParameter("type");
		String result;
		
		if(type.equalsIgnoreCase("ticket"))
		{
			result = sendEmail.sendTicketDetailsToUser(name, email, source, destination, passengersCount, fare, txnid, dateTime);
			if(result.equalsIgnoreCase("Email Sent"))
			{
				session.removeAttribute("Source");
				session.removeAttribute("Destination");
				session.removeAttribute("PassengersCount");
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
