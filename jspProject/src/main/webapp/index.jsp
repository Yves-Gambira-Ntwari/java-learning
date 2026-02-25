<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Hello my name is Gambira now we are <%= new java.util.Date() %></h2>
<h2>Add Two Numbers</h2>

	<form action="Add" method="post">
    Number 1: <input type="text" name="num1"><br><br>
    Number 2: <input type="text" name="num2"><br><br>
    <input type="submit" value="Add">
</form>
<%@ include file="footer.jsp" %>
</body>
</html>