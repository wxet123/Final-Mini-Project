package com.team2.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.DAO.AddEmpTrainingDAO;
import com.team2.model.AddEmpTraining;


@WebServlet("/addemptraining")
public class AddEmpTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		


		String employee = request.getParameter("empUsername");
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime =request.getParameter("endTime");
		String instructor = request.getParameter("instructor");
		int status = Integer.parseInt(request.getParameter("status"));
		int training_id  = Integer.parseInt(request.getParameter("training_id"));
		
		
		AddEmpTraining add = new AddEmpTraining(employee, training_id);
				
				
		try {
			
			if(AddEmpTrainingDAO.isConflict(add)) 
			{
				
				response.sendRedirect("adderror.jsp");
			}
			
			else {
				
				AddEmpTrainingDAO.addTraining(add);
				response.sendRedirect("enroll.jsp");
			}
			
		}
		
		catch(Exception e ){
			e.printStackTrace();
		}
		
		
	}

}
