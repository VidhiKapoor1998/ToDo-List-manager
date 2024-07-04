package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import entity.User;
import sessionFactory.Factory;



public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    public UserLogin() {
        super();
        
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside userLogin servlet...");
		
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		    response.setDateHeader("Expires", 0); // Proxies
		    
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("PrintWriter object created...");
		
		HttpSession httpSession=request.getSession(false);
		
		System.out.println("httpSession created...");
		
		User user=new User(Integer.parseInt(request.getParameter("LoginId")), request.getParameter("password"));
		System.out.println(user.getId()+" | "+ user.getPassword());
		
		System.out.println("User alloted...");
		
		Session session=Factory.getSessionFactory().openSession();
		System.out.println("session created...");
		
		User data=(User)session.get(User.class, user.getId());
		System.out.println("data fetched...");
		System.out.println(data);
		
		
		
		if(data!=null) {
			System.out.println("data is not null");
			
			
			if(data.getPassword().equals(user.getPassword())) {
				System.out.println("data found...");
				httpSession.setAttribute("user", data);
				httpSession.setAttribute("userId", data.getId());
				response.sendRedirect("index.jsp");
			}
			else {
				System.out.println("wrong credentials");
				out.print("wrong credentials");
			}
		}
		else {
			System.out.println("Data not found..");
		}
		
	}

}
