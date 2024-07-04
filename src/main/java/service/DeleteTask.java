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



public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	public DeleteTask() {
    
	
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside deleteTask servlet...");
		
		response.setContentType("text/HTML");
		PrintWriter out=response.getWriter();
		HttpSession httpSession=request.getSession();
		
		
		System.out.println("Fetching taskid...");
		Integer taskId=Integer.parseInt(request.getParameter("TaskId").trim());
		
		System.out.println("taskid found...");
		Session session=Factory.getSessionFactory().openSession();
		
		Task task=(Task)session.get(Task.class, taskId);
		Transaction transaction=session.beginTransaction();
		
		session.delete(task);
		transaction.commit();
		response.sendRedirect(request.getContextPath()+"/ViewTask");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
