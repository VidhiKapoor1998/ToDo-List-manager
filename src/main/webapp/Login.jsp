<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<% 
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>



</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
    <h2>Welcome to My Todo list manager</h2>
    <!-- Your page content here -->



	<form action="UserLogin" method="post">
		<input type="text" placeholder="Enter user id here" name="LoginId" required/><br><br>
		<input type="password" placeholder="Enter password here" name="password" required/><br><br>
		<input type="submit" value="Login">
	</form>
	
	

</body>
</html>