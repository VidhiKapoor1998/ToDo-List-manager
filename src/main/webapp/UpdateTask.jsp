<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.hibernate.Session"%>
<%@page import="sessionFactory.Factory"%>
<%@page import="entity.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="index.jsp"><button type="Submit">Home</Button></a><br><br>
	<%
		Integer taskid=Integer.parseInt(request.getParameter("TaskId").trim());
		Task task=Factory.getSessionFactory().openSession().get(Task.class, taskid);
	
	%>
	<form action="UpdateTask" method="post">		
		<input type="text"  name="title"  value="<%=task.getTitle()%>"><br><br>
		<textarea rows="5" cols="100"    name="description"><%=task.getDescription() %></textarea><br><br>
		<input type="text"  name="id"  value="<%=taskid%>" type="hidden"><br><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>