package com.team2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.DAO.RemoveDAO;
import com.team2.model.Remove;


@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int training_id = Integer.parseInt(request.getParameter("training_id"));
		
		
		
		Remove course = new Remove();
		course.setTraining_id(training_id);;
		
		
		try {
			
			RemoveDAO.removeCourse(course);
			response.sendRedirect("adminListOfTrainings.jsp");
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
