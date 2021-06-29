package com.team2.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.DAO.EvaluationDAO;
import com.team2.model.Evaluation;

@WebServlet("/evaluate")
public class EvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EvaluationDAO evaluationDAO;
	
	public void init() throws ServletException {
		evaluationDAO = new EvaluationDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		RequestDispatcher dispatcher = request.getRequestDispatcher("evaluation.jsp");
//		dispatcher.forward(request, response);
		try {
			insertEvaluation(request, response);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	private void insertEvaluation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String question_one = request.getParameter("q1");
		String question_two = request.getParameter("q2");
		String question_three = request.getParameter("q3");
		String question_four = request.getParameter("q4");
		String question_five = request.getParameter("q5");
		String comments = request.getParameter("comments");
		String status = request.getParameter("btn-submit");
		String evaluationStatus, message;
		PrintWriter out = response.getWriter();
		if(status.equals("submit")) {
			evaluationStatus = "Evaluated";
			message = "Thank you for your feedback.";
		} else {
			evaluationStatus = "Not Evaluated";
			message = "Error: Not evaluated";
		}
		
		Evaluation newEvaluation = new Evaluation(question_one, question_two, question_three, question_four, question_five, comments, evaluationStatus);
		evaluationDAO.insertEvaluation(newEvaluation);
		out.println("<script type=text/javascript>");
		out.println("alert('"+ message +"');");
		out.println("location='dashboard.jsp';");
		out.println("</script>");
//		response.sendRedirect("list");
	
	}

}
