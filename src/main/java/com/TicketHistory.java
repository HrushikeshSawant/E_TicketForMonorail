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
import bean.TicketHistoryBean;
import dao.TicketHistoryDao;

/**
 * Servlet implementation class TicketHistory
 */
public class TicketHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(TicketHistory.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ArrayList<TicketHistoryBean> ticketHistory;
		String email = (String)session.getAttribute("Email");
		
		LoginBean loginBean = new LoginBean(email);
		TicketHistoryDao ticketHistoryDao = new TicketHistoryDao();
		ticketHistory = ticketHistoryDao.getTicketHistory(loginBean);
		
		if(!ticketHistory.isEmpty())
		{
			request.setAttribute("TicketHistory", ticketHistory);
			request.getRequestDispatcher("/ticket-history.jsp").forward(request, response);
		}
		else if(ticketHistory.size() == 0)
		{
			request.setAttribute("NoData", "No data available");
			request.getRequestDispatcher("/ticket-history.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/ticket-history.jsp").forward(request, response);
		}
	}

}
