package com.team2.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.DAO.CreateTrainingDao;
import com.team2.model.CreateTraining;
import com.team2.model.Login;

@WebServlet("/addtraining")
public class CreateTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CreateTrainingDao addtrainingDao;
	
	

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		

		String course_id = request.getParameter("course_id");
		String course_title = request.getParameter("course_title");
		String description = request.getParameter("description");
		int Status = Integer.parseInt(request.getParameter("status"));
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime =request.getParameter("endTime");
		String instructor = request.getParameter("instructor");

		CreateTraining createTrainings = new CreateTraining(course_id, course_title, description, Status, date, startTime, endTime, instructor);

		
		
		try {
			if(CreateTrainingDao.isConflict(createTrainings))
			{
				
				response.sendRedirect("addTrainingError.jsp");
			}else {
				
				CreateTrainingDao.insertTrainings(createTrainings);
				response.sendRedirect("successAdd.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}
	

}
