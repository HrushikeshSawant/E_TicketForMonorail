<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style4.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/newPassword.css" type="text/css"/>
<title>New Password</title>
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

		<div class="curve">
			<img src="<%=request.getContextPath()%>/resources/images/logo.png" width="200"></img>.
		</div>	
		
		<div class="box">
			<div class = "header">		
				<p>New Password</p>	
			</div>		
			<form class = "form" action = "NewPassword" method = "post" id = "form" name = "form">					
					<div class="form-group has-feedback">			
					<label for = "passInput">New Password</label>
					<input type = "Password" class="form-control" id = "passInput" name = "passInput">
					<span id="passInputStatus" class="errorHeader">Password is required!</span>	
				</div>
				<br/>				
				<div class="form-group has-feedback">		
					<label for = "cpassInput">Confirm New Password</label>
					<input type = "password" class="form-control" id = "cpassInput" name = "cpassInput">
					<span id="cpassInputStatus" class="errorHeader">Confirm Password is required!</span>
				</div>	
				<br/><br/>					
				<button type = "submit" class = "button">Change Password</button>
				<span class="e2">${Message}</span><br/>			
			</form>
		</div>

	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/newPasswordValidation.js"></script>
</body>
</html>