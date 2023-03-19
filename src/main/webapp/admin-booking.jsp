<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylee6.css" type="text/css"/>
<title>Admin Booking</title>
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
			<p class="welcome">ADMIN BOOKING</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-tie"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a href="admin-welcome.jsp">Home</a>
						<a href="Logout">Logout</a>
					</div>
				</div>
			</nav>
		</header>
	
	<div class="container1">
		
		<div class="cont1">
			<a href="Booking?type=single-ticket&user-type=admin"><i class="fas fa-ticket-alt fa-3x"></i>Single Ticket</a>
		</div>
		<div class="cont1">
			<a href="Booking?type=book-pass&user-type=admin"><i class="fas fa-calendar-check fa-3x"></i>Book Pass</a>
		</div>
						
	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>

</body>
</html>