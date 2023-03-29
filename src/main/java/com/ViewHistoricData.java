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

import bean.UserBean;
import dao.HistoricUserDetailsDao;

/**
 * Servlet implementation class ViewHistoricData
 */
public class ViewHistoricData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(ViewHistoricData.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ArrayList<UserBean> historicUserDetails;
		
		HistoricUserDetailsDao historicUserDao = new HistoricUserDetailsDao();
		historicUserDetails = historicUserDao.getActiveUserDetails();
		
		if(historicUserDetails.get(0).getSize() != 0)
		{
			log.info("Historic data available");
			request.setAttribute("HistoricUserDetails", historicUserDetails);
			request.getRequestDispatcher("/historic-user-details.jsp").forward(request, response);
		}
		else if(historicUserDetails.get(0).getSize() == 0)
		{
			log.info("No historic data available");
			request.setAttribute("HistoricUserDetails", "HistoricUserDetails");
			request.getRequestDispatcher("/historic-user-details.jsp").forward(request, response);
		}
		else
		{
			log.info("Something went wrong, Please try again..");
			request.setAttribute("Error", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
