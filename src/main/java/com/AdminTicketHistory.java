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

import bean.AdminTicketHistoryBean;
import bean.LoginBean;
import dao.TicketHistoryDao;

/**
 * Servlet implementation class AdminTicketHistory
 */
public class AdminTicketHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(AdminTicketHistory.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ArrayList<AdminTicketHistoryBean> adminTicketHistory;
		String email = (String)session.getAttribute("Email");
		
		LoginBean loginBean = new LoginBean(email);
		TicketHistoryDao ticketHistoryDao = new TicketHistoryDao();
		adminTicketHistory = ticketHistoryDao.getAdminTicketHistory(loginBean);
		
		if(!adminTicketHistory.isEmpty())
		{
			request.setAttribute("AdminTicketHistory", adminTicketHistory);
			request.getRequestDispatcher("/admin-ticket-history.jsp").forward(request, response);
		}
		else if(adminTicketHistory.size() == 0)
		{
			request.setAttribute("NoData", "No data available");
			request.getRequestDispatcher("/admin-ticket-history.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/admin-ticket-history.jsp").forward(request, response);
		}
	}
}
