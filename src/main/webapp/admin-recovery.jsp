<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style3.css" type="text/css"/>
<title>Forgot Password</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/logo.ico" />
</head>
<body>
	<div class="container">
		
		<div class="curve">
			<img src="<%=request.getContextPath()%>/resources/images/logo.png" width="200"></img>.
			<p class="head">Forgot Password</p><br/>
			<div class="link">
				<p class="cont"><a href = "admin-login.jsp" class = "link"><i class="fas fa-user"></i>&nbsp;&nbsp;Sign In </a></p>
			</div>
		</div>	
		
		<div class="box">
			<div class = "header">		
				<p>Recover</p>		
			</div>	
			<form class = "form" action="AdminRecovery" method="post" id = "form" name = "form">	
				<div class="form-group has-feedback">			
					<label for = "emailInput">Email</label>
					<input type = "text" class="form-control" id = "emailInput" name = "emailInput" autocomplete="off" required>
					<span  class="e1">${Email}</span><br/>					
					<button type = "submit" class = "button">Next</button>	
					<span  class="e2">${Message}</span>		
				</div>		
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