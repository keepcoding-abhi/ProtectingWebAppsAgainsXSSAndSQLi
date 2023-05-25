<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
h3 {
	color:yellow;
}
</style>
</head>
<body bgcolor = "pink">
	<center>
	<br />
	<h1>PICT CENTRAL BANK</h1>
	<br />
	<hr />
	<br /><br />
	<%
		Object obj = session.getAttribute("printError");
		if(obj != null) {
			//System.out.println("Want to alert.");
			session.removeAttribute("printError");
			out.print("<h3>" +(String)obj + "</h3>");
		}
	%>
	<form action = "VerifyCredentials" method = "post">
		<label for = "user_name">Enter username :</label>
		 <input type = "text" name = "user_name" placeholder = "Username" /><br />
		 <br />
		<label for = "password">Enter password : </label>
		<input type = "password" name = "password" placeholder = "Password" /><br />
		<br />
		<input type = "submit" value = "Login"/>
	</form><br /><br />
	<a href = "feedback.jsp">Please give feedback</a>
	</center>
</body>
</html>