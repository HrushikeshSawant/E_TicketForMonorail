package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.GetStationNamesBean;
import dao.GetStationNamesDao;

/**
 * Servlet implementation class Booking
 */
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(Booking.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		log.trace("Getting type of booking");
		String type = request.getParameter("type");
		
		GetStationNamesDao getStationNamesDao = new GetStationNamesDao();
		ArrayList<GetStationNamesBean> getStationNames = getStationNamesDao.getStationNames();
		
		if(!getStationNames.isEmpty())
		{
			if(type.equalsIgnoreCase("single-ticket"))
			{
				log.trace("Redirected to Single Ticket");
				session.setAttribute("getStationNames", getStationNames);
				request.getRequestDispatcher("/single-ticket.jsp").forward(request, response);
			}
			else if(type.equalsIgnoreCase("book-pass"))
			{
				log.trace("Redirected to Book Pass");
				session.setAttribute("getStationNames", getStationNames);
				request.getRequestDispatcher("/book-pass.jsp").forward(request, response);
			}
		}
		else
		{
			log.trace("Something went wrong while getting station names in booking");
			request.setAttribute("Error", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
