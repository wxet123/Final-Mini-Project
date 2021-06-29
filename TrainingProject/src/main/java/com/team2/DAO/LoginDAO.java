package com.team2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team2.model.Employee;
import com.team2.model.Login;

public class LoginDAO {

	public boolean validate(Login login) throws ClassNotFoundException{
		boolean status = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		  try (Connection connection = DriverManager
				  .getConnection("jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "Neverwinter132!");


		           PreparedStatement preparedStatement = connection
				            .prepareStatement("select * from employee where username = ? and password = ? ")) {
				            preparedStatement.setString(1, login.getUsername());
				            preparedStatement.setString(2, login.getPassword()); 
				    
				            
				            
		            ResultSet rs = preparedStatement.executeQuery();
		            
		            
		            while(rs.next()) {
		            	if(  rs.getString("username").equals(login.getUsername()) 
		            			&& rs.getString("password").equals(login.getPassword())) {
		            		return true;
		            	}  
		            }
		            
		  
		         }
		         catch (SQLException e) {
		            printSQLException(e);
		        }
		        return status;
		    }
	
	
	
	public boolean adminValidation(Login login) throws ClassNotFoundException {
		
		boolean status = false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		  try (Connection connection = DriverManager
				  .getConnection("jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "Neverwinter132!");


		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select * from employee where username = ? and password = ? ")) {
		            preparedStatement.setString(1, login.getUsername());
		            preparedStatement.setString(2, login.getPassword()); 
		    
		            
		            
		            
		            ResultSet rs = preparedStatement.executeQuery();

		            while(rs.next()) {

			            if(rs.getInt("isAdmin") == 1)
			            {
			            	status = true;
			            }
			           
			            }
		        } catch (SQLException e) {
		            printSQLException(e);
		        }
		        return status;
		    }
		
	
	public boolean adminValidationDashboard(Login login) throws ClassNotFoundException {
		
		boolean status = false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		  try (Connection connection = DriverManager
				  .getConnection("jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "Neverwinter132!");


		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select * from employee where username = ?")) {
		            preparedStatement.setString(1, login.getUsername());
		    
		            
		            
		            
		            ResultSet rs = preparedStatement.executeQuery();

		            while(rs.next()) {

			            if(rs.getInt(7) == 1)
			            {
			            	status = true;
			            }
			           
			            }
		        } catch (SQLException e) {
		            printSQLException(e);
		        }
		        return status;
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



	public boolean isAdmin(boolean adminStatus) {
		// TODO Auto-generated method stub
		return false;
	}
}
		
	
			
