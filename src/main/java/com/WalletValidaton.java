package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WalletValidaton
 */
public class WalletValidaton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		if(amount <= 0)
		{
			request.setAttribute("Err", "Please Enter Valid Amount!");
			request.getRequestDispatcher("/wallet.jsp").forward(request, response);
		}
		else
		{
			session.setAttribute("Amount", amount);
			response.sendRedirect("payment.jsp");
		}
		
	}

}
