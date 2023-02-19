<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylee5.css" type="text/css"/>
<title>Welcome</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/logo.ico" />
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Email")==null){
			response.sendRedirect("login.jsp");
		}
	%>
		<header>
			<img src="${pageContext.request.contextPath}/resources/images/logo.png" class="logo"></img>
			<p class="welcome">WELCOME</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-tie"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a onclick="document.getElementById('id01').style.display='block'; document.getElementById('container1').style.display='none'; document.getElementById('footer').style.display='none';">Delete Account</a>
						<a href="Logout">Logout</a>
					</div>
				</div>
			</nav>
		</header>

		<div id="id01" class="modal">
			<span onclick="document.getElementById('id01').style.display='none'; document.getElementById('container1').style.display='flex'; document.getElementById('footer').style.display='flex';" class="close">x</span>
			<div class="model-content">
				<div class="container2">
					<br/><br/><h1>Delete Account</h1><br/><br/>
					<p>Are you sure you want to delete your account?</p>
								    
					<div class="clearfix">
						<a onclick="document.getElementById('id01').style.display='none'; document.getElementById('container1').style.display='flex'; document.getElementById('footer').style.display='flex';" class="cancelbtn">Cancel</a>
						<a href="DeleteMe" class="deletebtn">Delete</a>
					</div>
				</div>
			</div>
		</div>
	
		<div class="container1" id="container1">
					
			<div class="cont1">				
					<a href="booking.jsp"><i class="fas fa-ticket-alt fa-3x"></i>Booking</a>
			</div>
			<div class="cont1">
					<a href="wallet.jsp"><i class="fas fa-wallet fa-3x"></i>Wallet</a>
			</div>
			<div class="cont1">		
					<a href="route.jsp"><i class="fas fa-route fa-3x"></i>Route</a>
			</div>
			<div class="cont1">	
					<a href="history.jsp"><i class="fas fa-history fa-3x"></i>History</a>
			</div>
		</div>
	<div class="container5" id="footer">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
</body>
</html>