<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Admin</title>
<style>
h3 {
	color:yellow;
}
</style>
</head>
<body bgcolor = "pink">
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		String uname = (String)session.getAttribute("username");
		if(uname == null) {
			response.sendRedirect("login.jsp");
		}
		if(session.getAttribute("admin_logged") == null) {
			response.sendRedirect("Logout");
		}
	%>
	<center>
	<br />
	<h1>PICT CENTRAL BANK</h1>
	<br />
	<hr />
	<br /><br />
	<%
		Object obj = session.getAttribute("printError");
		if(obj != null) {
			session.removeAttribute("printError");
			out.print("<h3>" +(String)obj + "</h3>");
		}
		
		out.print("<h2> Welcome "+ uname + "</h2>");
	%>
	<br /><br />
	<form>
	<%
		out.print("<input type = 'text' name = 'username' value = '" + uname + "' style = 'display:none;' />");
	%>
		<input type = "submit" formaction = "showData.jsp" value = "View Your Profile" /><br /><br />
		<input type = "submit" formaction = "add_user.jsp" value = "Add New User" /><br /><br />
		<input type = "submit" formaction = "remove_user.jsp" value = "Remove Account" /><br /><br />
		<input type = "submit" formaction = "Logout" value = "Logout" />
	</form>
	</center>
</body>
</html>