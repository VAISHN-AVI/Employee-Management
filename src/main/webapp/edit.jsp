<%@page import="jspp_employe.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Employee employee=(Employee)request.getAttribute("emp"); %>

<form action="update" method="post">
	Id: <input type="hidden" name="id" value=<%=employee.getId() %>> <br>
	Name: <input type="text" name="name" value=<%=employee.getName() %>><br>
	Phone: <input type="tel" name="phone"value=<%=employee.getPhone() %>><br>
	Email: <input type="text" name="email"value=<%=employee.getEmail() %>><br>
	designation: <input type="text" name="designation" value=<%=employee.getDesignation() %>><br>
	salary: <input type="text" name="salary" value=<%=employee.getSalary() %>><br>
	Password: <input type="text" name="password" value=<%=employee.getPassword() %>><br>
	<button> Update</button>
	</form>

</body>
</html>