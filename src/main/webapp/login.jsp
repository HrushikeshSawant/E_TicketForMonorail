<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css"/>
<link href="<%=request.getContextPath()%>/resources/css/error2.css" rel="stylesheet" >
<title>Login</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/logo.ico" />
</head>
<body>
	<%
		if(session.getAttribute("Email") != null){
			session.removeAttribute("Email");
		}
	%>
	<div class="container">	
			
			<div class="curve">
				<img src="<%=request.getContextPath()%>/resources/images/logo.png" width="200"></img>.
				<p class="head">Sign In To Your Account</p><br/>
				<div class="link">
					<p class="cont"><a href = "register.jsp" class = "link"><i class="fas fa-user-plus"></i>&nbsp;&nbsp;Create Account </a></p>
					<p class="cont"><a href = "recovery.jsp" class = "link"><i class="fas fa-key"></i>&nbsp;&nbsp;Forgot Password?</a></p>
				</div>
			</div>	

			<div class="box">
				<div class = "header">		
					<p>Login</p>	
				</div>		
				<form class = "form" action = "Login" method = "post" id = "form" name = "form">					
					<div class="form-group has-feedback">			
						<label for = "email">Email</label>
						<input type = "text" class="form-control" id = "emailInput" name = "emailInput" onblur = "emailValidate()" autocomplete="off">
						<span id="emailInputStatus" class="errorHeader">Email address is required!</span>	
						<span  class="e1" id="e1">${Email}</span>			
					</div>
					<br/>				
					<div class="form-group has-feedback">		
						<label for = "password">Password</label>
						<input type = "password" class="form-control" id = "passInput" name = "passInput" onblur = "passwordValidate()">
						<span id="passInputStatus" class="errorHeader">Password is required!</span>	
						<span class="e3" id="e3">${Pass}</span>		
					</div>	
					<br/><br/>					
					<button type = "submit" class = "button">Login</button>
					<span class="e2" id="e2">${Message}</span>			
				</form>
			</div>

	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/LoginValidation.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/errorValidation2.js"></script>
</body>
</html>