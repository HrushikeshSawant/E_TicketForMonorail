<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.GetStationNamesBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylea7.css" type="text/css"/>
<title>Book Ticket</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/logo.ico" />
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Name")==null){
			response.sendRedirect("admin-login.jsp");
		}
	%>
	<header>
			<img src="<%=request.getContextPath()%>/resources/images/logo.png" class="logo"></img>
			<p class="welcome">TICKET BOOKING</p>
			<nav>
				<div class="dropdown">
					<i class="fas fa-user-secret"></i>&nbsp;&nbsp;${Name}
					<div class="bar">
						<p class="blank"></p>
						<a href="admin-welcome.jsp">Home</a>
						<a href="Logout">Logout</a>
					</div>
				</div>
			</nav>
		</header>
	<div class="container">
		<div class="box">
		<div class = "head">		
			Single Ticket	
		</div>
		<form class="form" action="SingleTicketBookingAdmin" method="post" id="form" name="form">
			<% ArrayList<GetStationNamesBean> getStationNames = (ArrayList<GetStationNamesBean>)session.getAttribute("getStationNames"); %>
			<div class="form-group has-feedback">
			<label for="source">Source Station:</label>
			<select name="source" id="source" class="form-control" required>
			
				<option value="" selected disabled>-- SELECT --</option>
				<%	
			        for(int i = 0 ; i < getStationNames.size() ; i++)
			        {
				%>	
						<option><%= getStationNames.get(i).getStationName() %></option>
				<%	
	        		}
		        %>
						
			</select>
			</div>
			<br/>
			<div class="form-group has-feedback">
			<label for="dest">Destination Station:</label>
			<select name="dest" id="dest" class="form-control" required>
			
				<option value="" selected disabled>-- SELECT --</option>
				<%	
			        for(int i = 0 ; i < getStationNames.size() ; i++)
			        {
				%>	
						<option><%= getStationNames.get(i).getStationName() %></option>
				<%	
	        		}
		        %>	
						
			</select>
			</div>
			<br/>							
			<label for="nosP">No.of Passengers</label>
			<input type="text" name="nosP" id="nosP" class="form-control1" autocomplete="off" required>
			<br/>
			<label for="Email">Email</label>
			<input type="Email" name="userEmail" id="Email" class="form-control1" autocomplete="off" required>
			<br/><br/>
			<button type="submit" class="button">Next</button>
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