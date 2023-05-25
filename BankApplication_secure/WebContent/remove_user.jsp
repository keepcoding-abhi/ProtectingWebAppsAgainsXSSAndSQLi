<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove account</title>
</head>
<body bgcolor="pink">
	<%
		if(session.getAttribute("username") == null) {
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
	<h2>Remove Account</h2>
	<form action = "RemoveUser">
		<label for = "delete_user">Enter the user name of account to delete :</label>
		<br /><br />
		<input type = "text" name = "delete_user"/>
		<br /><br />
		<input type = "submit" value = "Submit"/>
	</form>
	</center>
</body>
</html>