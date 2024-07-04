<html>
<body>

	<a href='<%= request.getContextPath() %>/Logout'><button type="Submit">Logout</Button></a><br><br>


	<table>
		<tr>	
			<td><a href="createTask.jsp"/>Create todo list</a>
		</tr>
		<tr>	
			<td><a href="<%=request.getContextPath() %>/ViewTask"/>View todo list</a></td>
		</tr>
	</table>

</body>
</html>
