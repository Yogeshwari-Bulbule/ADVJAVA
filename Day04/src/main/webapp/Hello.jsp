<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple JSP</title>
</head>
<body>
	<% 
		int[] arr = {1, 2, 3, 4, 5};
		for (int i = 0; i < arr.length; i++){
	%>
	<h1> Hii </h1>
	<h2>arr[<%= i %>] = <%= arr[i] %></h2>
	
	<% 
		}
	%>
</body>
</html>