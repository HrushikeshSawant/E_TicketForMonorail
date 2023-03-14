package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.AdminRecoveryDao;
import other.OTP;
import other.sendEmail;

/**
 * Servlet implementation class AdminRecovery
 */
public class AdminRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(AdminRecovery.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.trace("Getting User Recovery info from UI");
		String result;
		String email = request.getParameter("emailInput");
		
		AdminRecoveryDao adminRecoveryDao = new AdminRecoveryDao();
		result = adminRecoveryDao.checkAdminEmailExist(email);
		
		if(result.equalsIgnoreCase("Email exists"))
		{
			HttpSession session = request.getSession();				
			session.setAttribute("Email", email);	
			String emailResult = sendEmail.adminPasswordChangeRequest(email);
			if(emailResult.equalsIgnoreCase("Email Sent"))
			{
				request.setAttribute("Message", "Password reset mail sent..");
				request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/admin-recovery.jsp").forward(request, response);
			}
		}
		else if(result.equalsIgnoreCase("Email does not exists"))
		{
			//IF EMAIL DOES NOT EXISTS
			log.trace("Email not found");
			request.setAttribute("Email", "Email not found!");
			request.getRequestDispatcher("/admin-recovery.jsp").forward(request, response);
		}
		else
		{
			//ON FAILURE OR ERROR
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/admin-recovery.jsp").forward(request, response);
		}
	}

}
