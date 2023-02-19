package com;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.LoginBean;
import dao.LoginDao;
import dao.UserDetailsDao;
import dao.WalletDao;
import other.Details;

/**
 * Servlet implementation class Wallet
 */
public class Wallet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(Wallet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
			HttpSession session = request.getSession(false);
			String result;
			String MOT = null;
			String email = (String)session.getAttribute("Email");
			String button = request.getParameter("btn");
			double wallet = (Double)session.getAttribute("Wallet");
			double amount = (Double)session.getAttribute("Amount");
			Details dt = new Details();
			String dateTime = dt.dateTime();
			Random random = new Random();
			String rndm = Integer.toString(random.nextInt())+(System.currentTimeMillis());
			String txnid = dt.hashCal("SHA-256", rndm).substring(0,20);
			
			if(button == null ) {
				//no button has been selected.
			}
			else if(button.equals("Pay")){
				MOT = "Bank";
			}
			else if(button.equals("PAY")) {
				MOT = "Card";
			}
			else {
				//JSP was altered and data has been send.
			}
			
			WalletDao walletDao = new WalletDao();
			result = walletDao.updatetransactionDetails(email, wallet, amount, MOT, txnid, dateTime);
			
			if(result.equalsIgnoreCase("Payment Successful"))
			{
				request.setAttribute("Msg", "Payment Successful!");
				LoginBean loginBean = new LoginBean(email);
				UserDetailsDao userDetailsDao = new UserDetailsDao();
				HashMap<String, String> userDetails = userDetailsDao.getUserDetails(loginBean);
				session.setAttribute("Wallet", Double.parseDouble(userDetails.get("Wallet")));
				request.getRequestDispatcher("/successful.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Payment Unsuccessful"))
			{
				//On Failure
				request.setAttribute("Err", "Payment Unsuccessful!");
				request.getRequestDispatcher("/wallet.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Msg", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/wallet.jsp").forward(request, response);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		
	}

}
