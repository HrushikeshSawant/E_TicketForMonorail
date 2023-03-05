package com;

import java.io.IOException;
import java.util.HashMap;

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
import other.PassWHash;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(Login.class);
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.trace("Getting User Login info from UI");
		String result;
		String email = request.getParameter("emailInput");
		String password = request.getParameter("passInput");
		String h_password = PassWHash.getMd5(password);
		
		if(email != "" && password != "")
		{
			log.trace("Login Getters and Setters Called");
			LoginBean loginBean = new LoginBean(email, password, h_password);
			LoginDao loginDao = new LoginDao();
			result = loginDao.verifyUserLogin(loginBean);
			
			if(result.equalsIgnoreCase("Login Successful"))
			{
				log.trace("Login Sucessful");
				UserDetailsDao userDetailsDao = new UserDetailsDao();
				HashMap<String, String> userDetails = userDetailsDao.getUserDetails(loginBean);
				
				if(userDetails.get("Status").trim().equalsIgnoreCase("Deleted"))
				{
					log.trace("Email not found");
					request.setAttribute("Email", "Email not found!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("Name", userDetails.get("Name"));
					session.setAttribute("Email", userDetails.get("Email"));
					session.setAttribute("Wallet", Double.parseDouble(userDetails.get("Wallet")));
					response.sendRedirect("welcome.jsp");
				}
			}
			else if(result.equalsIgnoreCase("Incorrect Password"))
			{
				//IF PASSWORD IS INCORRECT
				log.trace("Incorrect Password");
				request.setAttribute("Pass", "Incorrect Password!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Email does not exists"))
			{
				//IF EMAIL DOES NOT EXISTS
				log.trace("Email not found");
				request.setAttribute("Email", "Email not found!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else
			{
				//ON FAILURE OR ERROR
				log.trace("Something went wrong while login");
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		else
		{
			log.trace("Email & Password is blank");
			request.setAttribute("Email", "Email address is required!");
			request.setAttribute("Pass", "Password is required!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
