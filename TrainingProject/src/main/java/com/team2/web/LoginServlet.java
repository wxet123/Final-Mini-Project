package com.team2.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.DAO.EmployeeDAO;
import com.team2.DAO.LoginDAO;
import com.team2.model.Employee;
import com.team2.model.Login;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private LoginDAO loginDAO; 
      private EmployeeDAO employeeDAO;
      
      public void init() {
    	  loginDAO = new LoginDAO();
    	  employeeDAO = new EmployeeDAO();
      }
	
  


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	
		
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		Employee emp = new Employee();
		emp.setUsername(username);
		
		 try {
			 	

	        	   if (loginDAO.adminValidation(login) ) {
	            	
	    			HttpSession session = request.getSession();
	    			session.setAttribute("username", username);
	                response.sendRedirect("adminDashboard.jsp"); //INSERT HOME PAGE
	            }
	            
	            else if(loginDAO.validate(login)){
	            	
	    			HttpSession session = request.getSession();
	    			session.setAttribute("username", username);
	    			
	                response.sendRedirect("dashboard.jsp");
	                
	            }
	            else {
	            	if(!employeeDAO.isExisting(emp)) {
	            		response.sendRedirect("nousererror.jsp");
	            	}else {
	            		response.sendRedirect("loginfailed.jsp");
	            }
	            	}
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	      
	      }
	}
}
