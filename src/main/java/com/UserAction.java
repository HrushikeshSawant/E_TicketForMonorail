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
import dao.GetUserDetailsDao;

/**
 * Servlet implementation class UserAction
 */
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(UserAction.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ArrayList<GetUserDetailsBean> userDetails;
		
		GetUserDetailsDao getUserDetailsDao = new GetUserDetailsDao();
		userDetails = getUserDetailsDao.getActiveUserDetails();
		
		if(!userDetails.isEmpty())
		{
			log.info("Get user details");
			request.setAttribute("UserDetails", userDetails);
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

}
