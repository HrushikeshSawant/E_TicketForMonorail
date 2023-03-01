package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(OTP.class);
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String OTP = request.getParameter("otpInput");
		String OTPGEN = (String) session.getAttribute("OTP");
		
		if(OTP.equalsIgnoreCase(OTPGEN))
		{
			log.info("OTP Validated");
			response.sendRedirect("new-password.jsp");
		}
		else
		{
			log.info("Wrog OTP entered");
			request.setAttribute("OTPN", "Please enter valid OTP!");
			request.getRequestDispatcher("otp.jsp").forward(request, response);
		}
		
	}

}
