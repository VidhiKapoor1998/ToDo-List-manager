package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import entity.Task;
import entity.User;
import sessionFactory.Factory;



public class ViewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public ViewTask() {
    
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("INSIDE VIEW TASK SERVLET");
		
		response.setContentType("text/HTML");
		PrintWriter out=response.getWriter();
		HttpSession httpSession=request.getSession();
		
		Session session=Factory.getSessionFactory().openSession();
		
		Integer user= (Integer) httpSession.getAttribute("userId");
		User list=(User)session.get(User.class, user);
		System.out.println("**********************"+list);
		
		if(list!=null) {
			
			System.out.println("list is not null");
			
			
		List<Task> task=new ArrayList<>();
		task=list.getTask();
		
		out.print("<a href=\"index.jsp\"><button type=\"Submit\">Home</Button></a><br><br>");
		
		out.print("<table border='4' style='border-collapse:collapse m-2 p-2' >" );  
				//+ "style=\\\"border:2px solid black\\\">\"
		out.print("<tr>"
				+ "<th>Title</th>"
				+ "<th>Description</th>"
				+ "</tr>");
		
		for(Task t:task) {
			
			
			System.out.println(t.getTitle());
			System.out.println("finding user's task");
			
			
				System.out.println("task found");
				httpSession.setAttribute("task", t);
				
				out.print("<tr>"
						+ "<td>"+t.getTitle()+"</td>"
						+ "<td>"+t.getDescription()+"</td>"
						+"<td><a href='UpdateTask.jsp?TaskId="+t.getId()+"'>Update</a></td>"
						+"<td><a href='"+request.getContextPath()+"/DeleteTask?TaskId="+t.getId()+"'>Delete</a></td>"
						+ "</tr>");
			
				System.out.println("task id:"+t.getId());
				
			
			
			
		}
		out.print("</table>");
		}
		else {
			
			System.out.println("List is null");
			out.print("<h1>Your task list is empty</h1>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
