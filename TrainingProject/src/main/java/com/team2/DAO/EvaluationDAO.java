package com.team2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team2.model.Evaluation;

public class EvaluationDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/employees";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Neverwinter132!";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
	private static final String INSERT_EVALUATION_SQL = "INSERT INTO evaluation "
			+ "(question_one, question_two, "
			+ "question_three, question_four, question_five, "
			+ "comments, evaluationStatus) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?);";

	
	public EvaluationDAO() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Neverwinter132!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//INSERT EVALUATION
	public String insertEvaluation(Evaluation evaluation) throws SQLException {
		System.out.println(INSERT_EVALUATION_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVALUATION_SQL)) {
			preparedStatement.setString(1, evaluation.getQuestion_one());
			preparedStatement.setString(2, evaluation.getQuestion_two());
			preparedStatement.setString(3, evaluation.getQuestion_three());
			preparedStatement.setString(4, evaluation.getQuestion_four());
			preparedStatement.setString(5, evaluation.getQuestion_five());
			preparedStatement.setString(6, evaluation.getComments());
			preparedStatement.setString(7, evaluation.getEvaluationStatus());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return null;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());
			
			Throwable t = ex.getCause();
			while(t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
			
		}
		
	}
	
	
	
}
