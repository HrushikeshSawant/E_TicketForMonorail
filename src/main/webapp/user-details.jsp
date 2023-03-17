<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.GetUserDetailsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylea13New.css" type="text/css"/>
<title>User Detals</title>
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
			<p class="welcome">USER DETAILS</p>
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
		<span class="e2">${Msg}</span>
		<div class="container">
			<table class="content">
			
				<tr>		
					<th>Name</th>
					<th>Email</th>
					<th>Account Status</th>
					<th colspan ="2">Details</th>
				</tr>
				
				<%
					ArrayList<GetUserDetailsBean> userDetails = (ArrayList<GetUserDetailsBean>)request.getAttribute("UserDetails");
					if(userDetails.get(0).getSize() != 0)
					{
				        for(int i = 1 ; i < userDetails.size() ; i++)
				        {
		        %>
							<tr>
								<td><%=userDetails.get(i).getName()%></td>
								<td><%=userDetails.get(i).getEmail()%></td>
								<td><%=userDetails.get(i).getAccountStatus()%></td>
								<td><a href="UserTransactionDetails?email=<%=userDetails.get(i).getEmail()%>&type=ticket" class="link">Ticket</a></td>
								<td><a href="UserTransactionDetails?email=<%=userDetails.get(i).getEmail()%>&type=pass" class="link">Pass</a></td>
							</tr>
				<%
		        		}
					}
			        else
			        {
		        %>
	        			<tr>
	        				<td colspan="5" class="msg">There are no Registrations yet.</td>
	        			</tr>
				 <%
		        	}
				%>
			</table>
		</div>
		<div class="container5">
			<div class="content5">
				&copy; 2020-21 Copyright: Designed and Developed by Hrushikesh Sawant.
			</div>
		</div>
	</body>
</html>