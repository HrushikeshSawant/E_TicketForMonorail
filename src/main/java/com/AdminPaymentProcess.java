package com;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.BookingTransactionDao;
import other.Details;

/**
 * Servlet implementation class AdminPaymentProcess
 */
public class AdminPaymentProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(AdminPaymentProcess.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try 
		{
			HttpSession session = request.getSession(false);
			double passengersCount = 0;
			String validFrom = null;
			String validThrough = null;
			String passType = null;
			String paymentType = request.getParameter("payment-type");
			String bookingType = request.getParameter("booking-type");
			String result = null;
			String name = (String)session.getAttribute("Name");
			String userEmail = (String)session.getAttribute("UserEmail");
			String adminEmail = (String)session.getAttribute("Email");
			String source = (String)session.getAttribute("Source");
			String destination = (String)session.getAttribute("Destination");
			double fare = (Double)session.getAttribute("Fare");
			
			//===FOR TICKET===//
			if(bookingType.equalsIgnoreCase("ticket"))
				passengersCount = (Double)session.getAttribute("PassengersCount");
			
			//===FOR TICKET===//
			if(bookingType.equalsIgnoreCase("pass"))
			{
				validFrom = (String)session.getAttribute("FromDate");
				validThrough = (String)session.getAttribute("ThroughDate");
				passType = (String)session.getAttribute("Type");
			}
			
			Details dt = new Details();
			String dateTime = dt.dateTime();
			Random random = new Random();
			String rndm = Integer.toString(random.nextInt())+(System.currentTimeMillis());
			String txnid = dt.hashCal("SHA-256", rndm).substring(0,20);
			
			BookingTransactionDao bookingTransactionDao = new BookingTransactionDao();
			
			//===FOR TICKET===//
			if(paymentType.equalsIgnoreCase("bank") && bookingType.equalsIgnoreCase("ticket"))
			{
				result = bookingTransactionDao.updateAdminTicketTransaction(adminEmail, userEmail, source, destination, passengersCount, fare, paymentType.toUpperCase(), txnid, dateTime);
			}
			else if(paymentType.equalsIgnoreCase("card") && bookingType.equalsIgnoreCase("ticket"))
			{
				result = bookingTransactionDao.updateAdminTicketTransaction(adminEmail, userEmail, source, destination, passengersCount, fare, paymentType.toUpperCase(), txnid, dateTime);
			}
			
			//===FOR PASS===//
			else if(paymentType.equalsIgnoreCase("bank") && bookingType.equalsIgnoreCase("pass"))
			{
				result = bookingTransactionDao.updateAdminPassTransaction(adminEmail, userEmail, source, destination, validFrom, validThrough, passType, fare, paymentType.toUpperCase(), txnid, dateTime);
			}
			else if(paymentType.equalsIgnoreCase("card") && bookingType.equalsIgnoreCase("pass"))
			{
				result = bookingTransactionDao.updateAdminPassTransaction(adminEmail, userEmail, source, destination, validFrom, validThrough, passType, fare, paymentType.toUpperCase(), txnid, dateTime);
			}
			
			//===FOR TICKET DATABASE UPDATE===//
			if(result.equalsIgnoreCase("Successful") && bookingType.equalsIgnoreCase("ticket"))
			{
				//ON SUCCESS
				request.setAttribute("Msg", "Ticket Booked Successfully!");
				session.setAttribute("dateTime", dateTime);
				session.setAttribute("txnid", txnid);
				request.getRequestDispatcher("/admin-ticket-details.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Unsuccessful") && bookingType.equalsIgnoreCase("ticket"))
			{
				//ON FAILURE
				request.setAttribute("Err", "Ticket not Booked!");
				request.getRequestDispatcher("/admin-single-ticket.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Something went wrong, Please try again..") && bookingType.equalsIgnoreCase("ticket") )
			{
				request.setAttribute("Msg", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/admin-single-ticket.jsp").forward(request, response);
			}
			
			//===FOR PASS DATABASE UPDATE===//
			if(result.equalsIgnoreCase("Successful") && bookingType.equalsIgnoreCase("pass"))
			{
				//ON SUCCESS
				request.setAttribute("Msg", "Pass Booked Successfully!");
				session.setAttribute("dateTime", dateTime);
				session.setAttribute("txnid", txnid);
				request.getRequestDispatcher("/admin-pass-details.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Unsuccessful") && bookingType.equalsIgnoreCase("pass"))
			{
				//ON FAILURE
				request.setAttribute("Err", "Pass not Booked!");
				request.getRequestDispatcher("/admin-book-pass.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Something went wrong, Please try again..") && bookingType.equalsIgnoreCase("pass") )
			{
				request.setAttribute("Msg", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/admin-book-pass.jsp").forward(request, response);
			}
			
		}
		catch (Exception e) {
			e.getMessage();
		}
		
	}

}
