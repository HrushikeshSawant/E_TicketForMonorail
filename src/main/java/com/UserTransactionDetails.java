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

import bean.LoginBean;
import bean.PassHistoryBean;
import bean.TicketHistoryBean;
import dao.PassHistoryDao;
import dao.TicketHistoryDao;

/**
 * Servlet implementation class UserTransactionDetails
 */
public class UserTransactionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(UserTransactionDetails.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String email = request.getParameter("email");
		String detailType = request.getParameter("type");
		
		LoginBean loginBean = new LoginBean(email);
		
		if(detailType.trim().equalsIgnoreCase("ticket"))
		{
			TicketHistoryDao ticketHistoryDao = new TicketHistoryDao();
			ArrayList<TicketHistoryBean> ticketHistory = ticketHistoryDao.getTicketHistory(loginBean);
			
			if(!ticketHistory.isEmpty())
			{
				request.setAttribute("TicketHistory", ticketHistory);
				request.getRequestDispatcher("/admin-user-ticket-history.jsp").forward(request, response);
			}
			else if(ticketHistory.size() == 0)
			{
				request.setAttribute("NoData", "No data available");
				request.getRequestDispatcher("/admin-user-ticket-history.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/admin-user-ticket-history.jsp").forward(request, response);
			}
		}
		else if(detailType.trim().equalsIgnoreCase("pass"))
		{
			PassHistoryDao passHistoryDao = new PassHistoryDao();
			ArrayList<PassHistoryBean> passHistory = passHistoryDao.getPassHistory(loginBean);
			
			if(!passHistory.isEmpty())
			{
				request.setAttribute("PassHistory", passHistory);
				request.getRequestDispatcher("/admin-user-pass-history.jsp").forward(request, response);
			}
			else if(passHistory.size() == 0)
			{
				request.setAttribute("NoData", "No data available");
				request.getRequestDispatcher("/admin-user-pass-history.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/admin-user-pass-history.jsp").forward(request, response);
			}
		}
	}

}
