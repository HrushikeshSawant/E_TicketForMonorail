<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylee8.css" type="text/css"/>
<title>Process</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/logo.ico" />
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Email")==null){
			response.sendRedirect("login.jsp");
		}
	%>
	<header>
			<img src="<%=request.getContextPath()%>/resources/images/logo.png" class="logo"></img>
			<p class="welcome">TICKET DETAILS</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-tie"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a href="welcome.jsp">Home</a>
						<a href="booking.jsp">Booking</a>
						<a href="Logout?user=user">Logout</a>
					</div>
				</div>
			</nav>
		</header>
	<div class="container">
	<div class="box">
		<div class = "head">		
			Ticket Details	
		</div>
	<form action="Payment" method="post" id="form" name="form" class="form">
		<input type="hidden" name = "booking-type" value = "single-ticket">
		<input type="hidden" name = "user-type" value = "user">
		<div class="link1"><p class="var">Name: </p>${Name}</div>
		<div class="link1"><p class="var">Email: </p>  ${Email}</div>
		<div class="link1"><p class="var">Source Station: </p> ${Source}</div>
		<div class="link1"><p class="var">Destination Station: </p> ${Destination}</div>
		<div class="link1">
			<p class="cont1">No. of Passengers:</p>${PassengersCount}
			<p class="cont2">Amount: <p class="value">${Fare}</p></p>
		</div>
		<h5>**Please check details before proceeding!</h5>
		<br/><br/>
		<button type="submit" class="button">Pay</button>
	</form>
	</div>
	</div>
	<div class="container5" id="footer">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
</body>
</html>