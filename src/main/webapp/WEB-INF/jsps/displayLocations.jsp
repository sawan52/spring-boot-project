<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Locations:</h2>
	<table>
		<tr>
			<th>id</th>
			<th>code</th>
			<th>name</th>
			<th>type</th>
		</tr>

		<c:forEach items="${locations}" var="loc">
			<tr>
				<td>${loc.id}</td>
				<td>${loc.code}</td>
				<td>${loc.name}</td>
				<td>${loc.type}</td>
				<td><a href="deleteLocation?id=${loc.id}">Delete</a></td>
				<td><a href="showUpdate?id=${loc.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="showCreate">Add Location</a>
</body>
</html>
