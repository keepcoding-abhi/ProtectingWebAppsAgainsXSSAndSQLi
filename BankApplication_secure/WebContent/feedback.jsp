<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank_application.dao.FeedbackDao, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback</title>
<style>
table {
	width : 100%;
	border-collapse : collapse;
}
table, th, td {
	border : 1px solid black;
}
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
	<h2>Feedback Form</h2>
	<%
		Object obj = session.getAttribute("printWarning");
		if(obj != null) {
			session.removeAttribute("printWarning");
			out.print("<h3>" + (String)obj + "</h3>");
		}
	%>
	<form action = "Feedback" method = "POST">
		<label for = "client_name">Your Name : </label>
		<input type = "text" name = "client_name"/><br /><br />
		<label for = "message">Feedback</label>
		<textarea rows = "3" cols = "40" name = "message"></textarea><br /><br />
		<input type = "submit" value = "Submit"/>
	</form>
	<br />
	<br />
	<table>
	<tr>
	 <th>Date Time</th>
	 <th>Name</th>
	 <th>Feedback</th>
	</tr>
	<%
		FeedbackDao feedback_database = new FeedbackDao();
		ArrayList<String[]> all_feedbacks = feedback_database.getPreviousFeedbacks();
		String current_feedback[];
		for(int i = 0 , n = all_feedbacks.size() ; i < n ; i++) {
			current_feedback = all_feedbacks.get(i);
			out.print("<tr>");
			for(int j = 0 ; j < 3 ; j++) {
				out.print("<td>" + current_feedback[j] + "</td>");
			}
			out.print("</tr>");
		}
	%>
	</table>
	</center>
</body>
</html>