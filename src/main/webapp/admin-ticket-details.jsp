<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylea9.css" type="text/css"/>
<title>Details</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/logo.ico" />
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Email")==null){
			response.sendRedirect("admin-login.jsp");
	}
	%>
		<header>
			<img src="<%=request.getContextPath()%>/resources/images/logo.png" class="logo"></img>
			<p class="welcome">TICKET BOOKED</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-tie"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a href="admin-welcome.jsp">Home</a>
						<a href="Logout?user=admin">Logout</a>
					</div>
				</div>
			</nav>
		</header>
		<div class="container">
		<div class="box">
		<div class = "head">		
			${Msg}	
		</div>
		<div class="form">
		<div class="link1"><p class="var">Email: </p>  ${UserEmail}</div>
		<div class="link1"><p class="var">Source Station: </p> ${Source}</div>
		<div class="link1"><p class="var">Destination Station: </p> ${Destination}</div>
		<div class="link1">
			<p class="cont1">No. of Passengers:</p>${PassengersCount}
			<p class="cont2">Amount: <p class="value1">${Fare}</p></p>
		</div>
		<div class="link1">
			<p class="cont5">Transaction Id: <p class="value2">${txnid}</p> </p> 
			<p class="cont6">Date and Time: <p class="value3">${dateTime}</p></p>			
		</div>
		<a href="SendDetailsMail?type=ticket&user-type=admin">Click Here to Redirect>></a>
		</div>
	</div>
	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
</body>
</html>