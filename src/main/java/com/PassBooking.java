package com;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.GetFareDao;

/**
 * Servlet implementation class PassBooking
 */
public class PassBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(PassBooking.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		double price;
		double fare;
		double mult = 0;
		String fromDate = null;
		String throughDate = null;
		String source = request.getParameter("source");
		String destination = request.getParameter("dest");
		String radio = request.getParameter("radio");
		
		LocalDate localDate = LocalDate.now();
		if(radio.equalsIgnoreCase("Monthly"))
		{
			fromDate = localDate.toString();
			throughDate = localDate.plusMonths(1).toString();
			mult = 29;
		}
		else if(radio.equalsIgnoreCase("Quarterly"))
		{
			fromDate = localDate.toString();
			throughDate = localDate.plusMonths(3).toString();
			mult = 85;
		}
		
		if(source.equalsIgnoreCase(destination))
		{
			//IF BOTH SOURCE AND DESTINATION ARE SAME
			log.trace("Source and Destination are same");
			request.setAttribute("Msg", "Source and Destination cannot be same!");
			request.getRequestDispatcher("/single-ticket.jsp").forward(request, response);
		}
		else
		{
			GetFareDao getFareDao = new GetFareDao();
			price = Double.parseDouble(getFareDao.getFareBetweenTwoStations(source, destination));
			fare = (price*mult);
			session.setAttribute("Source", source);
			session.setAttribute("Destination", destination);
			session.setAttribute("FromDate", fromDate);
			session.setAttribute("ThroughDate", throughDate);
			session.setAttribute("Type", radio);
			session.setAttribute("Fare", fare);
			request.getRequestDispatcher("/pass-booking-process.jsp").forward(request, response);
		}
		
	}

}
