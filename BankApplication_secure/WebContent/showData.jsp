<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank_application.dao.ProfileDao, com.bank_application.UserProfile"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Info.</title>
<style>
table {
	width : 100%;
	border-collapse : collapse;
}
table, th, td {
	border : 4px solid black;
}
</style>
</head>
<body bgcolor = "pink">
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
		
		String user_name = request.getParameter("username");
		ProfileDao pd = new ProfileDao();
		UserProfile profile = pd.getUserProfile(user_name);
	%>
	<center>
	<br />
	<h1>PICT CENTRAL BANK</h1>
	<br />
	<hr />
	<br /><br />
	<h2>Your Profile</h2>
	<table>
	<tr>
		<td>User Name</td>
		<td>
		<%
			out.print(profile.getUser_name());
		%>
		</td>
	</tr>
	<tr>
		<td>Full name</td>
		<td>
		<%
			out.print(profile.getFull_name());
		%>
		</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>
		<%
			out.print(profile.getAddress());
		%>
		</td>
	</tr>
	<tr>
		<td>Debit Card Number</td>
		<td>
		<%
			out.print(profile.getDebit_card());
		%>
		</td>
	</tr>
	<tr>
		<td>Credit Card Number</td>
		<td>
		<%
			out.print(profile.getCredit_card());
		%>
		</td>
	</tr>
	<tr>
		<td>Mobile Number</td>
		<td>
		<%
			out.print(profile.getMobile_number());
		%>
		</td>
	</tr>
	<tr>
		<td>Email-id</td>
		<td>
		<%
			out.print(profile.getEmail_id());
		%>
		</td>
	</tr>
	<tr>
		<td>Is administrator?</td>
		<td>
		<%
			String is_admin, form_action;
			if(profile.getIs_admin()) {
				is_admin = "Yes";
				form_action = "welcome_admin.jsp";
			}
			else {
				is_admin = "No";
				form_action = "welcome.jsp";
			}
			out.print(is_admin);
		%>
		</td>
	</tr>
	</table>
	<br /><br />
	<form>
		<%
			out.print("<input type = \"submit\" value = \"Go to Menu\" formaction = \"" + form_action + "\"  />");
		%>
		<br /><br />
		<input type = "submit" value = "Logout" formaction = "Logout" />
	</form>
	</center>	
</body>
</html>