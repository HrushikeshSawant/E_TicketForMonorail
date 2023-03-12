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
import dao.WalletDao;
import other.Details;

/**
 * Servlet implementation class PaymentProcess
 */
public class PaymentProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(PaymentProcess.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
			HttpSession session = request.getSession(false);
			String result = null;
			String email = (String)session.getAttribute("Email");
			String source = (String)session.getAttribute("Source");
			String destination = (String)session.getAttribute("Destination");
			double passengersCount = (Double)session.getAttribute("PassengersCount");
			double fare = (Double)session.getAttribute("Fare");
			Details dt = new Details();
			String dateTime = dt.dateTime();
			Random random = new Random();
			String rndm = Integer.toString(random.nextInt())+(System.currentTimeMillis());
			String txnid = dt.hashCal("SHA-256", rndm).substring(0,20);
			String paymentType = request.getParameter("payment-type");
			String bookingType = request.getParameter("booking-type");
			double wallet = (Double)session.getAttribute("Wallet");
			System.out.println(paymentType);
			System.out.println(bookingType);

			BookingTransactionDao bookingTransactionDao = new BookingTransactionDao();
			
			if(paymentType.equalsIgnoreCase("bank") && bookingType.equalsIgnoreCase("ticket"))
			{
				result = bookingTransactionDao.updateTicketTransaction(email, source, destination, passengersCount, fare, paymentType.toUpperCase(), txnid, dateTime);
			}
			else if(paymentType.equalsIgnoreCase("card") && bookingType.equalsIgnoreCase("ticket"))
			{
				result = bookingTransactionDao.updateTicketTransaction(email, source, destination, passengersCount, fare, paymentType.toUpperCase(), txnid, dateTime);
			}
			else if(paymentType.equalsIgnoreCase("wallet") && bookingType.equalsIgnoreCase("ticket"))
			{
				if(wallet < fare)
				{
					request.setAttribute("Msg", "You dont have enough wallet amount to pay use another method to pay!");
					request.getRequestDispatcher("/single-ticket.jsp").forward(request, response);
				}
				else
				{
					WalletDao walletDao = new WalletDao();
					result = bookingTransactionDao.updateTicketTransaction(email, source, destination, passengersCount, fare, paymentType.toUpperCase(), txnid, dateTime);
					wallet = Double.parseDouble(walletDao.getWalletAmount(email));
					session.setAttribute("Wallet", wallet);
				}
			}
			
			if(result.equalsIgnoreCase("Successful") && bookingType.equalsIgnoreCase("ticket"))
			{
				//ON SUCCESS
				request.setAttribute("Msg", "Ticket Booked Successfully!");
				session.setAttribute("dateTime", dateTime);
				session.setAttribute("txnid", txnid);
				request.getRequestDispatcher("/ticket-details.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Unsuccessful") && bookingType.equalsIgnoreCase("ticket"))
			{
				//ON FAILURE
				request.setAttribute("Err", "Ticket not Booked!");
				request.getRequestDispatcher("/single-ticket.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Msg", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/single-ticket.jsp").forward(request, response);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

}
