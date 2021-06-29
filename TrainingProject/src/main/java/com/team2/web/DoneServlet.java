package com.team2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.DAO.DoneDAO;
import com.team2.model.Done;

@WebServlet("/done")
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		int training_id = Integer.parseInt(request.getParameter("training_id"));
		
		
		
		Done course = new Done();
		course.setTraining_id(training_id);;
		
		
		try {
			
			DoneDAO.updateStatus(course);
			response.sendRedirect("adminListOfTrainings.jsp");
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
	}

}
