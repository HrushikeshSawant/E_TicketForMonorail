package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.NewPasswordDao;
import other.PassWHash;

public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(NewPassword.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String Email = (String) session.getAttribute("Email"); 
		String password = request.getParameter("passInput");
		String h_password = PassWHash.getMd5(password);
		
		String result;
		NewPasswordDao newPasswordDao = new NewPasswordDao();
		result = newPasswordDao.updatePassword(Email, h_password);
		
		if(result.equalsIgnoreCase("Password updated"))
		{
			//IF PASSWORD IS UPDATED
			log.trace("Password not changed! Please try again..");
			request.setAttribute("Message", "Password Updated!");
			session.removeAttribute(Email);
			session.invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if(result.equalsIgnoreCase("Password not updated"))
		{
			//IF PASSWORD NOT UPDATED
			log.trace("Password not changed! Please try again..");
			request.setAttribute("Message", "Password not changed! Please try again..");
			request.getRequestDispatcher("/new-password.jsp").forward(request, response);
		}
		else
		{
			//ON FAILURE OR ERROR
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/new-password.jsp").forward(request, response);
		}
		
	}

}
