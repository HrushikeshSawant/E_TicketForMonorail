<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link href="<%=request.getContextPath()%>/resources/css/styleNew.css" rel="stylesheet" >
<link href="<%=request.getContextPath()%>/resources/css/error2.css" rel="stylesheet" >
<title>Register</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/logo.ico" />
</head>
<body>
	<div class="container">	

		<div class="curve">
				<img src="<%=request.getContextPath()%>/resources/images/logo.png" width="200"></img>.
				<p class="head">Sign Up Your Account</p><br/>
				<div class="link">
					<p class="cont"><a href = "login.jsp" class = "link"><i class="fas fa-user"></i>&nbsp;&nbsp;Sign In </a></p>
				</div>
		</div>
		
		<div class="box">		

		<div class = "header">		
			<p>Create Account</p>		
		</div>		
		<form class = "form" action = "Register" method = "post" id = "form" name = "form">		
			<div class="form-group has-feedback">			
				<label for = "name">Name</label>
				<input type = "text" class="form-control" id = "nameInput" name = "nameInput" onblur = "nameValidate()" autocomplete="off">
				<span id="nameInputStatus" class="errorHeader">Name field is required!</span>
			</div>
			<br/>			
			<div class="form-group has-feedback">			
				<label for = "email">Email</label>
				<input type = "text" class="form-control" id = "emailInput" name = "emailInput" onblur = "emailValidate()" autocomplete="off">
				<span id="emailInputStatus" class="errorHeader">Email address is required!</span>	
				<!-- <span class="e1" id="e1"><%=request.getAttribute("Email")%></span> -->	
				<span class="e1" id="e1">${Email}</span>			
			</div>
			<br/>		
			<div class="form-group has-feedback">			
				<label for = "mob_no">Mobile No.</label>
				<input type = "tel" class="form-control" id = "mobInput" name = "mobInput" onblur = "mobileValidate()" autocomplete="off">
				<span id="mobInputStatus" class="errorHeader">Mobile Number is required!</span>		
				<!-- <span class="e3" id="e3"><%=request.getAttribute("Mobile")%></span> -->
				<span class="e3" id="e3">${Mobile}</span>
			</div>
			<br/>			
			<div class="form-group has-feedback">		
				<label for = "password">Password</label>
				<input type = "password" class="form-control" id = "passInput" name = "passInput" onblur = "passwordValidate()">
				<span id="passInputStatus" class="errorHeader">Password is required!</span>		
			</div>	
			<br/>		
			<div class="form-group has-feedback">			
				<label for = "c_password">Confirm Password</label>
				<input type = "password" class="form-control" id = "cpassInput" name = "cpassInput" onblur = "cpasswordValidate()">
				<span id="cpassInputStatus" class="errorHeader">Confirm Password is required!</span>		
			</div>
			<br/><br/>					
			<button type = "submit" class = "button">Register</button>
			<!-- <span class="e2" id="e2"><%=request.getAttribute("Message")%></span><br/> -->	
			<span class="e2" id="e2">${Message}</span><br/>
		</form>
		</div>
	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/Validation.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/errorValidation2.js"></script>
</body>
</html>