<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylee10.css" type="text/css" />
		<title>Wallet</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/logo.ico" />
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			if (session.getAttribute("Email") == null) {
				response.sendRedirect("login.jsp");
			}
		%>
	
		<header> 
			<img src="${pageContext.request.contextPath}/resources/images/logo.png" class="logo"></img>
			<p>
				Wallet Amount: <i class="fas fa-rupee-sign"></i> ${Wallet}
			</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-tie"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a href="welcome.jsp">Home</a> 
						<a href="Logout?user=user">Logout</a>
					</div>
				</div>
			</nav> 
		</header>
		<div class="container">
			<div class="box">
				<div class="head">Add Wallet</div>
				<form action="WalletValidaton" method="post" name="form" id="form" class="form">
					<label for="amount">Enter Amount</label> 
					<input type="text" class="form-control" id="amount" name="amount" autocomplete="off" required><br /><br />
					<button type="submit" class="button">Proceed</button>
					<span class="e1">${Err}</span> 
					<span class="e2">${Msg}</span>
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