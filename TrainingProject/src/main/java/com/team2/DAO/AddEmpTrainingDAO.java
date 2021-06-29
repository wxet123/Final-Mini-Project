package com.team2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.team2.model.AddEmpTraining;

public class AddEmpTrainingDAO{

	
	
	
	
	
	
	public static int addTraining(AddEmpTraining add) throws SQLException {
		int result = 0;
		
		String query = "insert into addemptraining (employee_id, training_id) values (? , ?);";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, getID(add.getEmployee_id()));
		ps.setInt(2, add.getTraining_id());
		
		result = ps.executeUpdate();
		
		return result;

		
	}
	
	
	public static boolean isConflict(AddEmpTraining add) {
		
		
		String query = "SELECT adt.enrollment_id, adt.training_id, ct.instructor, ct.date, ct.startTime, ct.endTime, e.employee_id from addemptraining adt join createtraining ct on adt.training_id = ct.training_id  join employee e on adt.employee_id = e.employee_id where ct.status = 1;";
		
		
		
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/elearning?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "Neverwinter132!");

				PreparedStatement ps = connection.prepareStatement(query)) {



			ResultSet rs = ps.executeQuery();

			while (rs.next()) {



				if (getID(add.getEmployee_id()) == rs.getInt("employee_id")) {
							
					if (add.getTraining_id() == (rs.getInt("training_id"))
							) {
						return true;

					}
				}
				else {
					return false;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}
	
	
	public static int getID(String emp) throws SQLException {
		
		
		String query = "select employee_id from employee where username = ?";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, emp);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			return rs.getInt("employee_id");
		}
		return 0;
		
	}
	

 public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning?useTimezone=true&serverTimezone=UTC","root","Neverwinter132!");
    }catch(Exception e){System.out.println(e);}
    return con;
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
