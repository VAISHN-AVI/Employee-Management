<%@page import="jspp_employe.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String value =(String) request.getAttribute("cookie");
	if(value!=null){
	%>
	
	<h2> Change by 
	<%=value %>
	</h2>
	
	<% 
	}
	%>
	
	<%
	List<Employee> list = (List) request.getAttribute("list");
	%>
	<table border="2px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Designation</th>
			<th>Salary</th>
			<th>Password</th>
		</tr>
		
		<%
		for (Employee employee : list) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getDesignation()%></td>
			<td><%=employee.getSalary()%></td>
			<td><%=employee.getPassword()%></td>
			<td><a href="delete?id=<%=employee.getId()%>" > <button>Delete</button> </a></td>
			<td><a href="update?id=<%=employee.getId()%>" > <button> Update </button> </a></td>
		</tr>
		<% 
}
%>

	</table>

</body>
</html>