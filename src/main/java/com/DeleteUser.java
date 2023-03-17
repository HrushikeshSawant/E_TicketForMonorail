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

import bean.GetUserDetailsBean;
import dao.DeleteUserDao;
import dao.GetUserDetailsDao;
import other.sendEmail;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(DeleteUser.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String result;
		String email = request.getParameter("email");
		
		DeleteUserDao deleteUserDao = new DeleteUserDao();
		result = deleteUserDao.deleteUser(email);
		
		if(result.equalsIgnoreCase("Account deleted"))
		{
			//IF ACCOUNT IS DELETED
			sendEmail.sendEmailToUser(email, "Admin delete", "");
			GetUserDetailsDao getUserDetailsDao = new GetUserDetailsDao();
			ArrayList<GetUserDetailsBean> userDetails = getUserDetailsDao.getActiveUserDetails();
			
			if(!userDetails.isEmpty())
			{
				log.info("Get user details");
				request.setAttribute("UserDetails", userDetails);
				request.setAttribute("Message", "Account Deleted Successfully!");
				request.getRequestDispatcher("/user-action.jsp").forward(request, response);
			}
			else if(userDetails.size() == 0)
			{
				log.info("Empty user details");
				request.setAttribute("NoData", "No data available");
				request.getRequestDispatcher("/user-action.jsp").forward(request, response);
			}
			else
			{
				log.info("Something went wrong, Please try again..");
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/user-action.jsp").forward(request, response);
			}
		}
		else if(result.equalsIgnoreCase("Account not deleted"))
		{
			//IF ACCOUNT IS NOT DELETED
			request.setAttribute("Message", "Account not Deleted!");
			request.getRequestDispatcher("/user-action.jsp").forward(request, response);
		}
		else
		{
			//ON FAILURE OR ERROR
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/user-action.jsp").forward(request, response);
		}
	}
}
