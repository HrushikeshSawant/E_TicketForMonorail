<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.PassHistoryBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylee13.css" type="text/css"/>
<title>Historic User Pass History</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/logo.ico" />
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Email")==null){
			response.sendRedirect("admin-login.jsp");
		}
		String Email = (String) session.getAttribute("Email");
	%>
		<header>
			<img src="${pageContext.request.contextPath}/resources/images/logo.png" class="logo"></img>
			<p class="welcome">HISTORIC USER PASS HISTORY</p>
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
		<div class="container">
		<table class="content">
		
			<tr>
				<th>Source</th>
				<th>Destination</th>
				<th>Valid From</th>
				<th>Valid Through</th>
				<th>Pass Type</th>
				<th>Mode of Transaction</th>
				<th>Fare</th>
				<th>Transaction Id</th>
				<th>Date and Time</th>
			</tr>
			
			<%
				ArrayList<PassHistoryBean> passHistory = (ArrayList<PassHistoryBean>)request.getAttribute("PassHistory");
				if(passHistory.get(0).getSize() != 0)
				{
			        for(int i = 1 ; i < passHistory.size() ; i++)
			        {
        	%>
						<tr>
			                <td><%=passHistory.get(i).getSource()%></td>
			                <td><%=passHistory.get(i).getDestination()%></td>
			                <td><%=passHistory.get(i).getValidFrom()%></td>
			                <td><%=passHistory.get(i).getValidThrough()%></td>
			                <td><%=passHistory.get(i).getPassType()%></td>
			                <td><%=passHistory.get(i).getModeofTransaction()%></td>
			                <td><%=passHistory.get(i).getFare()%></td>
			                <td><%=passHistory.get(i).getTxnid()%></td>
			                <td><%=passHistory.get(i).getDateTime()%></td>
			            </tr>
	        <%
	        		}
				}
		        else
		        {
	        %>
	        			<tr>
	        				<td colspan="9">No data available</td>
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