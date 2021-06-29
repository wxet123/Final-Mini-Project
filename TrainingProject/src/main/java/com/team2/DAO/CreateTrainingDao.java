package com.team2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.team2.model.CreateTraining;

public class CreateTrainingDao {

	// .getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
	// "root", "root");
	public static int insertTrainings(CreateTraining createTraining) throws ClassNotFoundException {
		String INSERT_Employees_SQL = "INSERT INTO createtraining"
				+ " (course_id, course_title, description,  date, startTime, endTime, instructor , status, username) VALUES "
				+ " (?, ?, ?, ? , ?, ?, ?, ?, ?);";

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/elearning?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "Neverwinter132!");

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Employees_SQL)) {

			preparedStatement.setString(1, createTraining.getCourse_id());
			preparedStatement.setString(2, createTraining.getCourse_title());
			preparedStatement.setString(3, createTraining.getDescription());
			preparedStatement.setString(4, createTraining.getDate());
			preparedStatement.setString(5, createTraining.getStartTime());
			preparedStatement.setString(6, createTraining.getEndTime());
			preparedStatement.setString(7, getInstructorInDb(createTraining.getInstructor()));
			preparedStatement.setInt(8, createTraining.getStatus());
			preparedStatement.setString(9, createTraining.getInstructor());

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;

	}


	
	
	public static boolean isConflict(CreateTraining createtraining) {

		boolean stat = false;
		String query = "select * from createtraining where date = ? and instructor = ?";

		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/elearning?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "Neverwinter132!");

				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, createtraining.getDate());
			ps.setString(2, getInstructorInDb(createtraining.getInstructor()));
			ResultSet rs = ps.executeQuery();

			String enrollStart = createtraining.getStartTime();
			String enrollEnd = createtraining.getEndTime();

			while (rs.next()) {

				String date = rs.getString("date");
				String start = rs.getString("startTime");
				String end = rs.getString("endTime");
				
				if (sdf.parse(createtraining.getDate()).equals(sdf.parse(date))) {

					return getTimeDifference(date, start, end, enrollStart, enrollEnd);

				} 

			}

		} catch (

		Exception e) {
			System.out.println(e);
		}
		return stat;

	}

	public static String getInstructorInDb(String username) throws ClassNotFoundException {

		String instructorNameInDb = "";

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/elearning?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "Neverwinter132!");

				PreparedStatement ps = con
						.prepareStatement("select first_name, last_name from employee where username = ?")) {

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				instructorNameInDb = rs.getString("first_name") + " " + rs.getString("last_name");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return instructorNameInDb;
	}

	public static int getInstrucotrEmpID(String username) throws ClassNotFoundException, SQLException {
		
	
		int empID = 0 ;
		
		

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/elearning?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "Neverwinter132!");

				PreparedStatement ps = con
						.prepareStatement("select employee_id from employee where username = ?")) {
				ps.setString(1, username);
				
				ResultSet rs = ps.executeQuery();
						
				while(rs.next()) {
					empID = rs.getInt("employee_id");
				}
				
			
		return empID;
	}
	}
	
	public static boolean isAlreadyAdded(CreateTraining createTraining) throws ClassNotFoundException {

		String query = "Select * from createtraining where course_id =? OR course_title =?";

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/elearning?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "Neverwinter132!");

				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, createTraining.getCourse_id());
			preparedStatement.setString(2, createTraining.getCourse_title());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				if (rs.getString("course_id").equals(createTraining.getCourse_id())
						|| rs.getString("course_title").equals(createTraining.getCourse_title())) {
					return true;
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;

	}

	private static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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

	public static String time(String strTime) {

		String hours = "";
		String minutes = "";
		String am_pm = "";
		String output = "";
		String strTime2 = "";

		if ((strTime.length() <= 4)) {

			strTime2 = 0 + strTime;
			for (int i = 0; i < strTime2.length(); i++) {

				if (i <= 1) {
					hours += strTime2.charAt(i);
				}

				if (i >= 3) {
					minutes += strTime2.charAt(i);
				}

			}

			int h = Integer.parseInt(hours);
			if (h >= 13) {
				hours = "" + (h - 12);
				am_pm = "PM";

			} else {
				if (h == 0) {
					hours = "12";
					am_pm = "AM";
					output = hours + ":" + minutes + " " + am_pm;
				}
				am_pm = "AM";
				output = hours + ":" + minutes + " " + am_pm;

			}

			output = hours + ":" + minutes + " " + am_pm;

		} else {
			for (int i = 0; i < strTime.length(); i++) {

				if (i <= 1) {
					hours += strTime.charAt(i);
				}

				if (i >= 3) {
					minutes += strTime.charAt(i);
				}
			}

			int h = Integer.parseInt(hours);

			if (h >= 13) {
				hours = "" + (h - 12);
				am_pm = "PM";
			} else {
				if (h == 0) {
					hours = "12";
					am_pm = "AM";
				}
				output = hours + ":" + minutes + " " + am_pm;
			}
			output = hours + ":" + minutes + " " + am_pm;
		}
		return (output);
	}

	public static boolean getTimeDifference(String date, String start, String end, String enrollStart, String enrollEnd)
			throws ParseException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");

		LocalDateTime s1 = LocalDateTime.parse(date + " " + start, dtf);
		LocalDateTime s2 = LocalDateTime.parse(date + " " + end, dtf);

		LocalDateTime e1 = LocalDateTime.parse(date + " " + enrollStart, dtf);
		LocalDateTime e2 = LocalDateTime.parse(date + " " + enrollEnd, dtf);

		Instant startTime = s1.toInstant(ZoneOffset.UTC);
		Instant endTime = s2.toInstant(ZoneOffset.UTC);
		Instant regStartTime = e1.toInstant(ZoneOffset.UTC);
		Instant regEndTime = e2.toInstant(ZoneOffset.UTC);

		if ((regStartTime.equals(endTime) || regStartTime.isAfter(endTime)) && (regEndTime.isAfter(regStartTime))) {

			return false;

		}

		else if ((regEndTime.equals(startTime) || regEndTime.isBefore(startTime))
				&& (regStartTime.isBefore(regEndTime))) {
			
			return false;
			
		} else {
			return true;
		}

	}

}
