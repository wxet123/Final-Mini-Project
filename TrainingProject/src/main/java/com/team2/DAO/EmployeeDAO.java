package com.team2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

import com.team2.model.Employee;


public class EmployeeDAO {
	
	
	public boolean isExisting(Employee employee)throws ClassNotFoundException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String query_employee_info = "Select username from employee where username = ?";
		boolean hasExisted = false;
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "Neverwinter132!");
	    		
				
				
	    		PreparedStatement preparedStatement = connection.prepareStatement(query_employee_info)){
						preparedStatement.setString(1, employee.getUsername());
						
	    				ResultSet rs  = preparedStatement.executeQuery();
	    				
	    				
	    				while(rs.next()) {
	    					
	    					if(rs.getString(1).equals(employee.getUsername()))
	    					{
	    						return hasExisted = true;
	    					
	    					}
	    					else { return hasExisted; }
	    				
	    			
	    				}
	    				
		}
		catch (SQLException e) {
	    	printSQLException(e);
	    }
	    return hasExisted;
	    
	}
		
		
	
		
	
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		String INSERT_EMPLOYEEINFO_SQL = "INSERT INTO employee" +
				" (first_name, last_name, username, password, address, contact, isAdmin) VALUES " +
				" (?, ?, ?, ?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "Neverwinter132!");
	    		
				
				
	    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEEINFO_SQL,Statement.RETURN_GENERATED_KEYS)){
				
	    				preparedStatement.setString(1, employee.getFirstName());
						preparedStatement.setString(2, employee.getLastName());
						preparedStatement.setString(3, employee.getUsername());
						preparedStatement.setString(4, employee.getPassword());
						preparedStatement.setString(5, employee.getAddress());
						preparedStatement.setString(6, employee.getContact());
						preparedStatement.setInt(7, employee.getIsAdmin());
						
	    				System.out.println(preparedStatement);
	    				result  = preparedStatement.executeUpdate();
	    				ResultSet tableKeys = preparedStatement.getGeneratedKeys();
	    				tableKeys.next();
	    				
	    				
	    				
	    				
	    } catch (SQLException e) {
	    	printSQLException(e);
	    }
	    return result;
	    
	}
	
	public int registerEmployee1(Employee employee) throws ClassNotFoundException{
		
		String INSERT_USERLOGIN_SQL = "INSERT INTO employee" +
				" (username, password, isAdmin) VALUES " +
				" (?, ?, ?);";

		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Neverwinter132!");
	    		
				
				
	    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERLOGIN_SQL,Statement.RETURN_GENERATED_KEYS)){
				
	    				
						preparedStatement.setString(1, employee.getUsername());
						preparedStatement.setString(2, employee.getPassword());
						preparedStatement.setInt(3, employee.getIsAdmin());
	    				
	    				System.out.println(preparedStatement);
	    				result  = preparedStatement.executeUpdate();
	    				ResultSet tableKeys = preparedStatement.getGeneratedKeys();
	    				tableKeys.next();
	    				
	    } catch (SQLException e) {
	    	printSQLException(e);
	    }
	    return result;
	    
	}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
