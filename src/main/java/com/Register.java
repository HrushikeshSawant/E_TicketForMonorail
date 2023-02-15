package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.User;
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
			log.info("Getting User values from UI");
			String name = request.getParameter("nameInput");
			String email = request.getParameter("emailInput");
			String mobile_no = request.getParameter("mobInput");
			String password = request.getParameter("passInput");
			String c_password = request.getParameter("cpassInput");
			String h_password = other.PassWHash.getMd5(password);
			
			log.info("Register Getters and Setters Called");
			User user = new User(name, email, mobile_no, password, c_password, h_password);
			
			RegisterDao dao = new RegisterDao();
			dao.verifyAndInsetNewUser(user);
		}
		catch(Throwable e)
		{
			log.error("Exception occurred in Register");
			request.setAttribute("Error", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
