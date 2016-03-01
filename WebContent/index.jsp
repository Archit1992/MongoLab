<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="<%=request.getContextPath() %>/ImdbController?flag=insert" method=post>
	<table>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="firstName" size=30></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lastName" size=30></td>
		</tr>
		<tr>
		 	<td><input type="submit" value="submit"></td>
		 	<td><input type="reset" value="Edit"></td>
		</tr>
	</table>	
</form>

</body>
</html>