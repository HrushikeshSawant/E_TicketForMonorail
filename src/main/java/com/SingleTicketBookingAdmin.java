package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.GetFareDao;

/**
 * Servlet implementation class SingleTicketBookingAdmin
 */
public class SingleTicketBookingAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(SingleTicketBookingAdmin.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		double price;
		double fare;
		String name = (String)session.getAttribute("Name");
		String source = request.getParameter("source");
		String destination = request.getParameter("dest");
		double passengersCount = Double.parseDouble(request.getParameter("nosP"));
		String email = request.getParameter("userEmail");
		
		if(source.equalsIgnoreCase(destination))
		{
			//IF BOTH SOURCE AND DESTINATION ARE SAME
			log.trace("Source and Destination are same");
			request.setAttribute("Msg", "Source and Destination cannot be same!");
			request.getRequestDispatcher("/admin-single-ticket.jsp").forward(request, response);
		}
		else
		{
			GetFareDao getFareDao = new GetFareDao();
			price = Double.parseDouble(getFareDao.getFareBetweenTwoStations(source, destination));
			fare = price * passengersCount;
			session.setAttribute("Source", source);
			session.setAttribute("Destination", destination);
			session.setAttribute("PassengersCount", passengersCount);
			session.setAttribute("Fare", fare);
			session.setAttribute("UserEmail", email);
			request.getRequestDispatcher("/admin-single-ticket-process.jsp").forward(request, response);
		}
		
	}

}
