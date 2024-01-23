<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Demo</title>
</head>
<body>
	<h3>Sum of 2 no's</h3>
	<%= 20 + 30 %><br/>
	<%= Math.random() %>
	
	<%
	out.println("Welcome to JSP");
	%>
	<%!
	int disp(){
		int a = 100;
		int b = 200;
		return(a+b);
}
%>

</body>
</html>