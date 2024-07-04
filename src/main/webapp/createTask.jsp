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
	
	<form action="AddTask" method="post">		
		<input type="text" placeholder="Title" name="title"/><br><br>
		<textarea rows="5" cols="100" placeholder="Description" name="description"></textarea><br><br>
		<input type="submit" value="Add">
	</form>
</body>
</html>