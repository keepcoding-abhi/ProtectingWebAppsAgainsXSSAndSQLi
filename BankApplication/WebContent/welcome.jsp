<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Client</title>
</head>
<body bgcolor = "pink">
	<center>
	<br />
	<h1>PICT CENTRAL BANK</h1>
	<br />
	<hr />
	<br /><br />
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		String uname = (String)session.getAttribute("username");
		if(uname == null) {
			response.sendRedirect("login.jsp");
		}
		if(session.getAttribute("admin_logged") != null) {
			response.sendRedirect("Logout");
		}
		out.print("<h1> Welcome " + uname + "</h1>");
	%>
	<br /><br />
	<form>
	<%
		out.print("<input type = \"text\" name = \"username\" value = \"" + uname + "\" style = \"display:none\"<br />");
	%>
		<input type = "submit" formaction = "showData.jsp" value = "View Your Profile"/><br /><br />
		<input type = "submit" formaction = "Logout" value = "Logout"/><br />
	</form>
	</center>
</body>
</html>