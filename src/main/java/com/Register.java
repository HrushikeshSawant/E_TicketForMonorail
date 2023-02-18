package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.UserBean;
import dao.RegisterDao;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger log = LogManager.getLogger(Register.class);
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try
		{
			log.trace("Getting User Registration info from UI");
			String result;
			String name = request.getParameter("nameInput");
			String email = request.getParameter("emailInput");
			String mobile_no = request.getParameter("mobInput");
			String password = request.getParameter("passInput");
			String c_password = request.getParameter("cpassInput");
			String h_password = other.PassWHash.getMd5(password);
			
			log.trace("Register Getters and Setters Called");
			UserBean user = new UserBean(name, email, mobile_no, password, c_password, h_password);
			
			RegisterDao dao = new RegisterDao();
			result = dao.verifyAndInsetNewUser(user);
			 
			if(result.equalsIgnoreCase("Successful"))
			{
				//ON SUCCESS
				request.setAttribute("Message", "Successfully registered. Sign In to continue..");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Mobile No. already exists"))
			{
				//IF MOBLE NO. ALREADY EXISTS
				request.setAttribute("Mobile", "Mobile No. already exists!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			else if(result.equalsIgnoreCase("Email already exists"))
			{
				//IF EMAIL ALREADY EXISTS
				request.setAttribute("Email", "Email already exists!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			else
			{
				//ON FAILURE OR ERROR
				request.setAttribute("Message", "Something went wrong, Please try again..");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
		catch(Throwable e)
		{
			log.error("Exception occurred in Register");
			request.setAttribute("Error", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
