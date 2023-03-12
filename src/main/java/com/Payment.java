package com;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UserDetailsDao;

/**
 * Servlet implementation class Payment
 */
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(Payment.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("Email");
		String type = request.getParameter("booking-type");
		
		if(type.trim().equalsIgnoreCase("single-ticket")) 
		{
			UserDetailsDao userDetailsDao = new UserDetailsDao();
			session.setAttribute("Wallet", Double.parseDouble(userDetailsDao.getWalletAmount(email)));
			request.getRequestDispatcher("/ticket-payment.jsp").forward(request, response);
		}
		else if(type.trim().equalsIgnoreCase(""))
		{
			
		}
	}

}
