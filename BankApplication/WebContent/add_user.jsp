<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New User</title>
</head>
<body bgcolor="pink">

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	String uname = (String)session.getAttribute("username");
	if(uname == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<center>
	<br />
	<h1>PICT CENTRAL BANK</h1>
	<br />
	<hr />
	<br /><br />
	<h2>New User Registration Form</h2>
	<form action = "AddUser" method = "post">
		<label for = "user_name">Username :</label>
		<input type = "text" name = "user_name" /><br/><br/>
		<label for = "password">Password :</label>
		<input type = "password" name = "password" /><br /><br />
		<label for = "full_name">Full Name :</label>
		<input type = "text" name = "full_name" /><br /><br />
		<label for = "address">Address :</label>
		<input type = "text" name = "address" /><br /><br />
		<label for = "debit_card">Debit Card Number :</label>
		<input type = "number" name = "debit_card" /><br /><br />
		<label for = "credit_card">Credit Card Number :</label>
		<input type = "number" name = "credit_card" /><br /><br />
		<label for = "mobile_number">Mobile Number :</label>
		<input type = "number" name = "mobile_number" /><br /><br />
		<label for = "email_id">Email id :</label>
		<input type = "text" name = "email_id" /><br /><br />
		
		<p>User category :</p>
		<input type = "radio" name = "user_type" value = "admin"/><label for = "admin">Admin</label>
		<input type = "radio" name = "user_type" value = "not_admin"checked /><label for = "not_admin">Not Admin</label>
		<br /><br />
		
		<input type = "submit" value = "Submit" />
	</form>
	
	
	</center>
</body>
</html>