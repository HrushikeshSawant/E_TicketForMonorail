<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.AdminTicketHistoryBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylea13New.css" type="text/css"/>
<title>Admin Ticket History</title>
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
			<p class="welcome">ADMIN TICKET HISTORY</p>
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
			<table class="content">
				
				<tr>
					<th>Email</th>
					<th>Source</th>
					<th>Destination</th>
					<th>No. of Passengers</th>
					<th>Amount</th>
					<th>Mode of Transaction</th>
					<th>Transaction Id</th>
					<th>Date and Time</th>
				</tr>
				<%
					ArrayList<AdminTicketHistoryBean> adminticketHistory = (ArrayList<AdminTicketHistoryBean>)request.getAttribute("AdminTicketHistory");
					if(adminticketHistory.get(0).getSize() != 0)
					{
				        for(int i = 1 ; i < adminticketHistory.size() ; i++)
				        {
        		%>
							<tr>
								<td><%=adminticketHistory.get(i).getUserEmail()%></td>
				                <td><%=adminticketHistory.get(i).getSource()%></td>
				                <td><%=adminticketHistory.get(i).getDestination()%></td>
				                <td><%=adminticketHistory.get(i).getPassengersCount()%></td>
				                <td><%=adminticketHistory.get(i).getModeofTransaction()%></td>
				                <td><%=adminticketHistory.get(i).getFare()%></td>
				                <td><%=adminticketHistory.get(i).getTxnid()%></td>
				                <td><%=adminticketHistory.get(i).getDateTime()%></td>
				            </tr>
		        <%
		        		}
					}
			        else
			        {
		        %>
		        			<tr>
		        				<td colspan="8">No data available</td>
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