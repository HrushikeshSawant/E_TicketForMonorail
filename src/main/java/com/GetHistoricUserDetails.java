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
import bean.WalletHistoryBean;
import dao.PassHistoryDao;
import dao.TicketHistoryDao;
import dao.WalletDao;

/**
 * Servlet implementation class GetHistoricUserDetails
 */
public class GetHistoricUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(GetHistoricUserDetails.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String email = request.getParameter("email");
		String detailType = request.getParameter("type");
		System.out.println(email);
		System.out.println(detailType);
		
		LoginBean loginBean = new LoginBean(email);
		
		if(detailType.trim().equalsIgnoreCase("wallet"))
		{
			WalletDao walletDao = new WalletDao();
			ArrayList<WalletHistoryBean> walletHistory = walletDao.getHistoricUserWalletHistory(loginBean);
			
			if(walletHistory.get(0).getSize() != 0)
			{
				request.setAttribute("WalletHistory", walletHistory);
				request.getRequestDispatcher("/historic-user-wallet-history.jsp").forward(request, response);
			}
			else if(walletHistory.get(0).getSize() == 0)
			{
				request.setAttribute("WalletHistory", walletHistory);
				request.getRequestDispatcher("/historic-user-wallet-history.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/historic-user-wallet-history.jsp").forward(request, response);
			}
		}
		else if(detailType.trim().equalsIgnoreCase("ticket"))
		{
			TicketHistoryDao ticketHistoryDao = new TicketHistoryDao();
			ArrayList<TicketHistoryBean> ticketHistory = ticketHistoryDao.getHistoricUserTicketHistory(loginBean);
			
			if(ticketHistory.get(0).getSize() != 0)
			{
				request.setAttribute("TicketHistory", ticketHistory);
				request.getRequestDispatcher("/historic-user-ticket-history.jsp").forward(request, response);
			}
			else if(ticketHistory.get(0).getSize() == 0)
			{
				request.setAttribute("TicketHistory", ticketHistory);
				request.getRequestDispatcher("/historic-user-ticket-history.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/historic-user-ticket-history.jsp").forward(request, response);
			}
		}
		else if(detailType.trim().equalsIgnoreCase("pass"))
		{
			PassHistoryDao passHistoryDao = new PassHistoryDao();
			ArrayList<PassHistoryBean> passHistory = passHistoryDao.getHistoricUserPassHistory(loginBean);
			
			if(passHistory.get(0).getSize() != 0)
			{
				request.setAttribute("PassHistory", passHistory);
				request.getRequestDispatcher("/historic-user-pass-history.jsp").forward(request, response);
			}
			else if(passHistory.get(0).getSize() == 0)
			{
				request.setAttribute("PassHistory", passHistory);
				request.getRequestDispatcher("/historic-user-pass-history.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/historic-user-pass-history.jsp").forward(request, response);
			}
		}
	}
}
