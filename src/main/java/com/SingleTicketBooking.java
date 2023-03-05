package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class SingleTicketBooking
 */
public class SingleTicketBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(SingleTicketBooking.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String source = request.getParameter("source");
		String destination = request.getParameter("dest");
		
		if(source.equalsIgnoreCase(destination))
		{
			//IF BOTH SOURCE AND DESTINATION ARE SAME
			log.trace("Source and Destination are same");
			request.setAttribute("Msg", "Source and Destination cannot be same");
			request.getRequestDispatcher("/single-ticket.jsp").forward(request, response);
		}
		else
		{
			
		}
	}

}
