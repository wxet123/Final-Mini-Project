package com.team2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.DAO.EmployeeDAO;
import com.team2.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDAO employeeDAO;

	public void init() {
		employeeDAO = new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName").trim().replaceAll("\\s+", " ");
		String lastName = request.getParameter("lastName").trim().replaceAll("\\s+", " ");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String userType = request.getParameter("radio");

		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);

		if (userType.equals("emp")) {
			employee.setIsAdmin(0);
		} else {
			employee.setIsAdmin(1);
		}

		try {
			if (!employeeDAO.isExisting(employee)) {

				employeeDAO.registerEmployee(employee);
				response.sendRedirect("registered.jsp");

			} else {

				response.sendRedirect("registerError.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
