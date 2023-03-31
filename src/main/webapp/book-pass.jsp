<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.GetStationNamesBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylee7.css" type="text/css">
<title>Pass</title>
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
			<p class="welcome">PASS BOOKING</p>
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
		<div class = "head">		
			Pass Booking	
		</div>
		<form class="form" action="PassBooking" method="post" id="form" name="form">
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
			<label>Select Pass Type:</label><br/>
			<div class="radiob">
			<input type="radio" class="pass" id="Monthly" value="Monthly" name="radio" checked>
			<label for="Monthly">Monthly</label>			
			<input type="radio" class="pass" id="Quarterly" value="Quarterly" name="radio">
			<label for="Quarterly">Quarterly</label>
			</div>
			<br/>
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