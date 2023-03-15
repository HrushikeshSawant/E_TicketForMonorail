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
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(AdminLogin.class);

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
			result = loginDao.verifyAdminLogin(loginBean);
			
			if(result.equalsIgnoreCase("Login Successful"))
			{
				log.trace("Login Sucessful");
				UserDetailsDao userDetailsDao = new UserDetailsDao();
				HashMap<String, String> adminDetails = userDetailsDao.getAdminDetails(loginBean);
				
					HttpSession session = request.getSession();
					session.setAttribute("Name", adminDetails.get("Name"));
					session.setAttribute("Email", adminDetails.get("Email"));
					response.sendRedirect("admin-welcome.jsp");
			}
			else if(result.equalsIgnoreCase("Incorrect Password"))
			{
				//IF PASSWORD IS INCORRECT
				log.trace("Incorrect Password");
				request.setAttribute("Pass", "Incorrect Password!");
				request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Email does not exists"))
			{
				//IF EMAIL DOES NOT EXISTS
				log.trace("Email not found");
				request.setAttribute("Email", "Email not found!");
				request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
			}
			else
			{
				//ON FAILURE OR ERROR
				log.trace("Something went wrong while login");
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
			}
		}
		else
		{
			log.trace("Email & Password is blank");
			request.setAttribute("Email", "Email address is required!");
			request.setAttribute("Pass", "Password is required!");
			request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
		}
	}

}
