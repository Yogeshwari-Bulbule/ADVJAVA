<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String name = "Radha"; %>
	<h1>Hello <%= name %></h1>
	
<%
String str = "Hello Everyone!";
%>
<h1><%= str %></h1>
<div style="text-align: center">
	<%
		for(int i=1; i<=6; i++) {
	%>
		<font size="<%= i %>">Hello World!</font> <br />
	<%
		}
	%>
</div>
<%
	
%>
</body>
</html>