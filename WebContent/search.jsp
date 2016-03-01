<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page import="org.bson.types.ObjectId"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="java.util.List"%>
<%@page import="com.mongodb.DBObject"%>
<%@ page import="controller.ImdbController"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<DBObject> s= (List<DBObject>)session.getAttribute("searchList");
	Iterator<DBObject> i=s.iterator();
	while(i.hasNext())
	{
		BasicDBObject a=(BasicDBObject)i.next();
		String first=a.getString("First Name");
		String last=a.getString("Last Name");
		ObjectId id=a.getObjectId("_id");
		
	
%>
	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Edit Action</td>
			<td>Delete Action</td>
		</tr>
			<tr>
				<td><c:out value="<%=first%>"></c:out></td>
				<td><c:out value="<%=last%>"></c:out></td>
				<td><a href="<%=request.getContextPath()%>/ImdbController?flag=edit&id=<%=id%>">Edit</a></td>
				<td><a href="<%=request.getContextPath()%>/ImdbController?flag=delete&id=<%=id%>">Delete</a></td>
			</tr>
<% } %>
	</table>



</body>
</html>