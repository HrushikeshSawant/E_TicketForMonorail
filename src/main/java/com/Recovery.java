package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.RecoveryDao;
import other.OTP;
import other.sendEmail;

/**
 * Servlet implementation class Recovery
 */
public class Recovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(Recovery.class);
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.trace("Getting User Recovery info from UI");
		String result;
		String otp;
		String email = request.getParameter("emailInput");
		
		RecoveryDao recoveryDao = new RecoveryDao();
		result = recoveryDao.checkEmailExist(email);
		
		if(result.equalsIgnoreCase("Email exists"))
		{
			HttpSession session = request.getSession();				
			session.setAttribute("Email", email);	
			OTP getOTP = new OTP();
			otp = getOTP.generateOTP();
			session.setAttribute("OTP", otp);
			String emailResult = sendEmail.sendEmailToUser(email, "otp", otp);
			if(emailResult.equalsIgnoreCase("Email Sent"))
			{
				request.getRequestDispatcher("/otp.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/recovery.jsp").forward(request, response);
			}
		}
		else if(result.equalsIgnoreCase("Email does not exists"))
		{
			//IF EMAIL DOES NOT EXISTS
			log.trace("Email not found");
			request.setAttribute("Email", "Email not found!");
			request.getRequestDispatcher("/recovery.jsp").forward(request, response);
		}
		else
		{
			//ON FAILURE OR ERROR
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/recovery.jsp").forward(request, response);
		}
	}

}
