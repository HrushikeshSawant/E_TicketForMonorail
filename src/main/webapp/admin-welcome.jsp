<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/adminwelcome.css" type="text/css"/>
<title>Admin</title>
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
			<p class="welcome">WELCOME</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-secret"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a href="Logout?user=admin">Logout</a>
					</div>
				</div>
			</nav>
		</header>
	<div class="container1">
			<div class="cont1">
				<a href="admin-booking.jsp"><i class="fas fa-ticket-alt fa-3x"></i>Booking</a>
			</div>
			<div class="cont1">
				<a href="GetUserDetails"><i class="fas fa-users fa-3x"></i>User Details</a>
			</div>
			<div class="cont1">
				<a href="UserAction"><i class="fas fa-users-cog fa-3x"></i>User Actions</a>
			</div>
			<div class="cont1">
				<a href="admin-history.jsp"><i class="fas fa-history fa-3x"></i>History</a>
			</div>
			<div class="cont1">
				<a href="historic-data.jsp"><i class="fas fa-history fa-3x"></i>Historic Data</a>
			</div>	
	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>
</body>
</html>