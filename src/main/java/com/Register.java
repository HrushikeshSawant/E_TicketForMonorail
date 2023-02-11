package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import other.PassWHash;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String name = request.getParameter("nameInput");
		String email = request.getParameter("emailInput");
		String mobile_no = request.getParameter("mobInput");
		String password = request.getParameter("passInput");
		String c_password = request.getParameter("cpassInput");
		String h_password = other.PassWHash.getMd5(password);
		
		User user = new User(name, email, mobile_no, password, c_password, h_password);
		
		
		
	}

}
