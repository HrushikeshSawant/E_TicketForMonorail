<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.AdminPassHistoryBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stylea13New.css" type="text/css"/>
<title>Admin Pass History</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/logo.ico" />
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Email")==null){
			response.sendRedirect("admin-login.jsp");
		}
	%>
		<header>
			<img src="${pageContext.request.contextPath}/resources/images/logo.png" class="logo"></img>
			<p class="welcome">ADMIN PASS HISTORY</p>
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
		<table class="content">
		
			<tr>
				<th>Email</th>
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
				ArrayList<AdminPassHistoryBean> adminPassHistory = (ArrayList<AdminPassHistoryBean>)request.getAttribute("AdminPassHistory");
				if(adminPassHistory.get(0).getSize() != 0)
				{
			        for(int i = 1 ; i < adminPassHistory.size() ; i++)
			        {
        	%>
						<tr>
							<td><%=adminPassHistory.get(i).getUserEmail()%></td>
			                <td><%=adminPassHistory.get(i).getSource()%></td>
			                <td><%=adminPassHistory.get(i).getDestination()%></td>
			                <td><%=adminPassHistory.get(i).getValidFrom()%></td>
			                <td><%=adminPassHistory.get(i).getValidThrough()%></td>
			                <td><%=adminPassHistory.get(i).getPassType()%></td>
			                <td><%=adminPassHistory.get(i).getModeofTransaction()%></td>
			                <td><%=adminPassHistory.get(i).getFare()%></td>
			                <td><%=adminPassHistory.get(i).getTxnid()%></td>
			                <td><%=adminPassHistory.get(i).getDateTime()%></td>
			            </tr>
	        <%
	        		}
				}
		        else
		        {
	        %>
	        			<tr>
	        				<td colspan="10">No data available</td>
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