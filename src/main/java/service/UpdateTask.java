package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Task;
import sessionFactory.Factory;



public class UpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public UpdateTask() {
    
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Inside UpdateTask servlet...");

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		Session session=Factory.getSessionFactory().openSession();
		
		Integer taskId=Integer.parseInt(request.getParameter("id"));
		
		Task task=session.get(Task.class, taskId);

		Transaction transaction=session.beginTransaction();
		
			task.setTitle(request.getParameter("title"));
			task.setDescription(request.getParameter("description"));
			transaction.commit();
		
		out.print("<h3>Task updated!!</h3>");
		
		out.print("<br><br><a href='index.jsp'><button type=\"Submit\">Home</Button></a>");
		
	}

}
