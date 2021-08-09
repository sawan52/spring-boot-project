<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Location</title>
</head>
<body>

	<form action="updateLoc" method="post">
		<pre>
Id: <input type="text" name="id" value="${loc.id}" readonly />
Code: <input type="text" name="code" value="${loc.code}" />
Name: <input type="text" name="name" value="${loc.name}" />
Type: Urban <input type="radio" name="type" value="URBAN"
				${loc.type=='URBAN'?'checked':''} />
	Rural <input type="radio" name="type" value="RURAL"
				${loc.type=='RURAL'?'checked':''} />
<input type="submit" value="save" />
</pre>
	</form>

</body>
</html>
