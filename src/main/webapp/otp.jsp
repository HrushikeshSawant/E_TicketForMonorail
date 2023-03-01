<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style4.css" type="text/css"/>
<title>OTP</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/logo.ico" />
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Email")==null){
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="container">
		
		<img src="<%=request.getContextPath()%>/resources/images/logo.png" width="200"></img>.
		<div class="box">
			<div class = "header">		
				<p>OTP</p>	
			</div>	
			<form class = "form" action="OTP" method="post" id = "form" name = "form">	
				<div class="form-group has-feedback">			
					<label for = "otpInput">Enter OTP</label>
					<input type = "password" class="form-control" id = "otpInput" name = "otpInput" autocomplete="off" required>
					<span  class="e1">${OTPN}</span><br/>
					<button type = "submit" class = "button">Verify</button>			
				</div>	
				<p class="txt">OTP has been sent to your Gmail account.</p>
			</form>
		</div>
	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
</body>
</html>