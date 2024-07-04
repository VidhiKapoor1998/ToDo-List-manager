package service;

import java.io.IOException;
import java.io.PrintWriter;
import entity.Task;
import entity.User;
import sessionFactory.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	public AddTask() {
    
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/HTML");
		PrintWriter out=response.getWriter();
		HttpSession httpSession=request.getSession();
		User user=(User) httpSession.getAttribute("user");
		
		Task task=new Task(request.getParameter("title"),
						   request.getParameter("description"),
						   user);
		
		Session session=Factory.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.save(task);
		transaction.commit();
		
		response.sendRedirect("index.jsp");
		

	}

}
