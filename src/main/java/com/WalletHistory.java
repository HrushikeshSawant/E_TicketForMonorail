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
import bean.WalletHistoryBean;
import dao.WalletDao;

/**
 * Servlet implementation class WalletHistory
 */
public class WalletHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(WalletHistory.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<WalletHistoryBean> walletHistory;
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("Email");
		
		LoginBean loginBean = new LoginBean(email);
		WalletDao walletDao = new WalletDao();
		walletHistory = walletDao.getWalletHistory(loginBean);
		
		if(!walletHistory.isEmpty())
		{
			request.setAttribute("WalletHistory", walletHistory);
			request.getRequestDispatcher("/walletHistory.jsp").forward(request, response);
		}
		else if(walletHistory.size() == 0)
		{
			request.setAttribute("NoData", "No data available");
			request.getRequestDispatcher("/walletHistory.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/walletHistory.jsp").forward(request, response);
		}
	}

}
