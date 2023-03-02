package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DeleteUserDao;
import other.sendEmail;

/**
 * Servlet implementation class DeleteMe
 */
public class DeleteMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(DeleteMe.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String result;
		String email = (String) session.getAttribute("Email");
		
		DeleteUserDao deleteUserDao = new DeleteUserDao();
		result = deleteUserDao.deleteUser(email);
		
		if(result.equalsIgnoreCase("Account deleted"))
		{
			//IF ACCOUNT IS DELETED
			sendEmail.sendEmailToUser(email, "User delete", "");
			session.removeAttribute("Email");
			session.invalidate();
			request.setAttribute("Message", "Account Deleted Successfully!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(result.equalsIgnoreCase("Account not deleted"))
		{
			//IF ACCOUNT IS NOT DELETED
			session.removeAttribute("Email");
			session.invalidate();
			request.setAttribute("Message", "Account not Deleted!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			//ON FAILURE OR ERROR
			session.removeAttribute("Email");
			session.invalidate();
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
