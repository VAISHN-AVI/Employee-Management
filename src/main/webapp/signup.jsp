<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h2><%=message%></h2>
	<%
	}
	%>

	<form action="save" method="post">
	Id: <input type="number" name="id"> <br>
	Name: <input type="text" name="name"><br>
	Phone: <input type="tel" name="phone"><br>

	Email: <input type="text" name="email"><br>
	designation: <input type="text" name="designation"><br>
	salary: <input type="text" name="salary"><br>
	Password: <input type="text" name="password"><br>
	<button> Register</button>
	</form>

</body>
</html>