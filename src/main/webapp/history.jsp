<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style5.css" type="text/css">
<title>History</title>
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
			<p class="welcome">HISTORY</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-tie"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a href="welcome.jsp">Home</a>
						<a href="Logout">Logout</a>
					</div>
				</div>
			</nav>
		</header>
	<div class="container1" id="container1">
					
			<div class="cont1">		
				<a href="ticketHistory.jsp"><i class="fas fa-ticket-alt fa-3x"></i>Ticket</a>
			</div>
			<div class="cont1">		
				<a href="passHistory.jsp"><i class="fas fa-calendar-check fa-3x"></i>Pass</a>
			</div>
			<div class="cont1">		
				<a href="WalletHistory"><i class="fas fa-wallet fa-3x"></i>Wallet</a>
			</div>
	</div>
	<div class="container5">
		<div class="content5">
			&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
		</div>
	</div>		
</body>
</html>