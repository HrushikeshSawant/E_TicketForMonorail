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

import bean.AdminPassHistoryBean;
import bean.LoginBean;
import dao.PassHistoryDao;

/**
 * Servlet implementation class AdminPassHistory
 */
public class AdminPassHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(AdminPassHistory.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ArrayList<AdminPassHistoryBean> adminPassHistory;
		String email = (String)session.getAttribute("Email");
		
		LoginBean loginBean = new LoginBean(email);
		PassHistoryDao passHistoryDao = new PassHistoryDao();
		adminPassHistory = passHistoryDao.getAdminPassHistory(loginBean);
		
		if(!adminPassHistory.isEmpty())
		{
			request.setAttribute("AdminPassHistory", adminPassHistory);
			request.getRequestDispatcher("/admin-pass-history.jsp").forward(request, response);
		}
		else if(adminPassHistory.size() == 0)
		{
			request.setAttribute("NoData", "No data available");
			request.getRequestDispatcher("/admin-pass-history.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Message", "Something went wrong, Please try again..");
			request.getRequestDispatcher("/admin-pass-history.jsp").forward(request, response);
		}
		
	}

}
