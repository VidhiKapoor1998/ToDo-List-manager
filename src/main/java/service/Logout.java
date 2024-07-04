package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sessionFactory.Factory;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	public Logout() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside Logout servlet");
		
		HttpSession httpSession=request.getSession(false);
		
		if(httpSession!=null) {
			
			System.out.println("session is not null");
			httpSession.invalidate();
			//Factory.closeFactory();
			
			response.sendRedirect("Login.jsp");
		}
	}



}
