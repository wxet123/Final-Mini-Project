package com.team2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team2.model.EnrolledStudents;
import com.team2.model.ListOfTrainings;

public class ListOfTrainingDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/elearning?useTimezone=true&serverTimezone=UTC", "root",
					"Neverwinter132!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static List<ListOfTrainings> getDoneCoursesPerInstructor(String username) throws ParseException {

		List<ListOfTrainings> listAll = new ArrayList<ListOfTrainings>();

		String query = "select * from createtraining where status = 2 and username = ?;";
		
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				

					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));

					int dateNumber = (date1.getDate());
					String dayName = (dayName(date1.getDay()));
					String month = month(date1.getMonth());
					String course_id = (rs.getString("course_id"));
					String course_title = (rs.getString("course_title"));
					String description = (rs.getString("description"));
					String date = (rs.getString("date"));
					String startTime = (time((rs.getString("startTime"))));
					String endTime = (time(rs.getString("endTime")));
					String instructor = (rs.getString("instructor"));
					int training_id = (rs.getInt("training_id"));
					int status = rs.getInt("status");

					listAll.add(new ListOfTrainings(course_id, course_title, status, date, dateNumber, dayName,
							startTime, endTime, instructor, description, training_id, month));
				
				}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return listAll;
	}
	
	public static List<EnrolledStudents> getStudentsEnrolled(String username, int training_id) {
		
		String query = "SELECT adt.enrollment_id, adt.training_id, ct.instructor, ct.date, ct.startTime, ct.endTime, e.employee_id , e.first_name, e.last_name from addemptraining adt join createtraining ct on adt.training_id = ct.training_id join employee e on adt.employee_id = e.employee_id where ct.status = 1;";
		
	
		
		List<EnrolledStudents> student = new ArrayList<EnrolledStudents>();

		
		
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
						
				while(rs.next()) {
					if(rs.getInt("training_id") == training_id) {
					String fullname = rs.getString("last_name") + ", " +rs.getString("first_name");
					
						student.add(new EnrolledStudents(fullname));
					
					}
				}
	
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		return student;
		
	}
	
	
public static List<EnrolledStudents> getDoneStudents(String username, int training_id) {
		
		String query = "SELECT adt.enrollment_id, adt.training_id, ct.instructor, ct.date, ct.startTime, ct.endTime, e.employee_id , e.first_name, e.last_name from addemptraining adt join createtraining ct on adt.training_id = ct.training_id join employee e on adt.employee_id = e.employee_id where ct.status = 2;";
		
	
		
		List<EnrolledStudents> student = new ArrayList<EnrolledStudents>();

		
		
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
						
				while(rs.next()) {
					if(rs.getInt("training_id") == training_id) {
					String fullname = rs.getString("last_name") + ", " +rs.getString("first_name");
					
						student.add(new EnrolledStudents(fullname));
					
					}
				}
	
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		return student;
		
	}
	public static List<ListOfTrainings> getRecords() throws ParseException {

		List<ListOfTrainings> listAll = new ArrayList<ListOfTrainings>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from createtraining");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				if(rs.getInt("status") == 1) {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));

					int dateNumber = (date1.getDate());
					String dayName = (dayName(date1.getDay()).toUpperCase());

					String month = month(date1.getMonth());
					String course_id = (rs.getString("course_id"));
					String course_title = (rs.getString("course_title"));
					String description = (rs.getString("description"));
					String date = (rs.getString("date"));
					String startTime = (time((rs.getString("startTime"))));
					String endTime = (time(rs.getString("endTime")));
					String instructor = (rs.getString("instructor"));
					int training_id = (rs.getInt("training_id"));
					int status = rs.getInt("status");

					listAll.add(new ListOfTrainings(course_id, course_title, status, date, dateNumber, dayName,
							startTime, endTime, instructor, description, training_id, month));

			}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listAll;
	}
	public static List<ListOfTrainings> getAllRecords(String username) throws ParseException {

		List<ListOfTrainings> listAll = new ArrayList<ListOfTrainings>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from createtraining where status = 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				if (rs.getString("username").equals(username)) {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));

					int dateNumber = (date1.getDate());
					String dayName = (dayName(date1.getDay()).toUpperCase());

					String month = month(date1.getMonth());
					String course_id = (rs.getString("course_id"));
					String course_title = (rs.getString("course_title"));
					String description = (rs.getString("description"));
					String date = (rs.getString("date"));
					String startTime = (time((rs.getString("startTime"))));
					String endTime = (time(rs.getString("endTime")));
					String instructor = (rs.getString("instructor"));
					int training_id = (rs.getInt("training_id"));
					int status = rs.getInt("status");

					listAll.add(new ListOfTrainings(course_id, course_title, status, date, dateNumber, dayName,
							startTime, endTime, instructor, description, training_id, month));

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listAll;
	}

	public static List<ListOfTrainings> getCoursesByInstructor(String username) throws ParseException{
	
	
	
	List<ListOfTrainings> listAll=new ArrayList<ListOfTrainings>();  
    
	
	String query = "select * from createtraining where instructor = ? ";
	
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(query);  
        ps.setString(1, username);
        
        ResultSet rs=ps.executeQuery();  
        
        while(rs.next()){  
        	
        	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));  
        	
        	int dateNumber = (date1.getDate());
        	String dayName = (dayName(date1.getDay()).toUpperCase());
        	
        	String month = month(date1.getMonth());
            String course_id = (rs.getString("course_id"));
            String course_title = (rs.getString("course_title")); 
            String description = (rs.getString("description"));
            String date = 			(rs.getString("date"));
            String startTime = (time((rs.getString("startTime"))));
            String endTime = (time(rs.getString("endTime")));
            String instructor = (rs.getString("instructor"));
            int training_id = (rs.getInt("training_id"));
            int status = rs.getInt("status");
            
            listAll.add(new ListOfTrainings(course_id, course_title, status, date, dateNumber, dayName, startTime,
            		endTime, instructor, description, training_id, month));
            
        	
        }}
    	catch(Exception e) {
        	System.out.println(e);
        	
        }

        return listAll;
}

	public static List<ListOfTrainings> enrollInProgressCoursesByEmpID(String username) throws ParseException {

		List<ListOfTrainings> listAll = new ArrayList<ListOfTrainings>();

		String query = "select * from createtraining where status = 1;";
		
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				
				if( !(isUserWithTrainingId(username, rs.getInt("training_id") ) ) )
				{
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));

					int dateNumber = (date1.getDate());
					String dayName = (dayName(date1.getDay()));
					String month = month(date1.getMonth());
					String course_id = (rs.getString("course_id"));
					String course_title = (rs.getString("course_title"));
					String description = (rs.getString("description"));
					String date = (rs.getString("date"));
					String startTime = (time((rs.getString("startTime"))));
					String endTime = (time(rs.getString("endTime")));
					String instructor = (rs.getString("instructor"));
					int training_id = (rs.getInt("training_id"));
					int status = rs.getInt("status");

					listAll.add(new ListOfTrainings(course_id, course_title, status, date, dateNumber, dayName,
							startTime, endTime, instructor, description, training_id, month));
				}
				}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return listAll;
	}
	
	public static boolean isUserWithTrainingId(String username, int training_id) {
		
		
		String query = "select * from addemptraining";
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				if( (getID(username) == rs.getInt("employee_id") && training_id == rs.getInt("training_id")) )
				{	
					return true;
				}
			}}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		
		
		return false;
		
	}
	
	
	public static List <ListOfTrainings> postInprogressPerEmp(String username){
	
		
		List<ListOfTrainings> listAll = new ArrayList<ListOfTrainings>();

		String query = "select * from addemptraining adt left join createtraining ct on adt.training_id = ct.training_id where ct.status = 1;";

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

					if( getID(username) == rs.getInt("employee_id") ) {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));

					int dateNumber = (date1.getDate());

					String dayName = (dayName(date1.getDay()));
					String month = month(date1.getMonth());

					String course_id = (rs.getString("course_id"));
					String course_title = (rs.getString("course_title"));
					String description = (rs.getString("description"));
					String date = (rs.getString("date"));
					String startTime = (time((rs.getString("startTime"))));
					String endTime = (time(rs.getString("endTime")));
					String instructor = (rs.getString("instructor"));
					int training_id = (rs.getInt("training_id"));
					int status = rs.getInt("status");

					listAll.add(new ListOfTrainings(course_id, course_title, status, date, dateNumber, dayName,
							startTime, endTime, instructor, description, training_id, month));

				}}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return listAll;
		
	}
	public static List<ListOfTrainings> getDoneByEmpID(String username){
		
		List<ListOfTrainings> listAll = new ArrayList<ListOfTrainings>();

		String query = "select adt.enrollment_id, adt.employee_id, ct.description, ct.training_id, ct.course_id, ct.course_title, ct.date, ct.startTime, ct.endTime, ct.instructor, ct.status from addemptraining adt right join createtraining ct on adt.training_id = ct.training_id where status = 2;";

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				if ((getID(username) == rs.getInt("employee_id")) ) {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));

					int dateNumber = (date1.getDate());

					String dayName = (dayName(date1.getDay()));
					String month = month(date1.getMonth());

					String course_id = (rs.getString("course_id"));
					String course_title = (rs.getString("course_title"));
					String description = (rs.getString("description"));
					String date = (rs.getString("date"));
					String startTime = (time((rs.getString("startTime"))));
					String endTime = (time(rs.getString("endTime")));
					String instructor = (rs.getString("instructor"));
					int training_id = (rs.getInt("training_id"));
					int status = rs.getInt("status");

					listAll.add(new ListOfTrainings(course_id, course_title, status, date, dateNumber, dayName,
							startTime, endTime, instructor, description, training_id, month));

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listAll;
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

				} else if (h >= 1 && h <= 9) {
					am_pm = "AM";
					output = 0 + hours + ":" + minutes + " " + am_pm;
				} else {

					am_pm = "AM";
					output = hours + ":" + minutes + " " + am_pm;
				}
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
					output = hours + ":" + minutes + " " + am_pm;
				} else {

					am_pm = "AM";
					output = hours + ":" + minutes + " " + am_pm;
				}
			}
			output = hours + ":" + minutes + " " + am_pm;
		}
		return (output);
	}

	public static int getID(String emp) throws SQLException {

		String query = "select employee_id from employee where username = ?";

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, emp);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			return rs.getInt("employee_id");
		}
		return 0;

	}

	public static int getInstrucotrEmpID(String username) throws ClassNotFoundException, SQLException {

		int empID = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/elearning?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "Neverwinter132!");

				PreparedStatement ps = con.prepareStatement("select employee_id from employee where username = ?")) {
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				empID = rs.getInt("employee_id");
			}

			return empID;
		}
	}

	public static String dayName(int dateInput) {

		String day = "";

		if (dateInput == 1) {
			day = "Mon";
		}

		if (dateInput == 2) {
			day = "Tue";
		}

		if (dateInput == 3) {
			day = "Wed";
		}
		if (dateInput == 4) {
			day = "Thu";
		}

		if (dateInput == 5) {
			day = "Fri";
		}
		if (dateInput == 6) {
			day = "Sat";
		}
		if (dateInput == 7) {
			day = "Sun";
		}
		return day;
	}

	public static String month(int dateInput) {

		String month = "";

		if (dateInput == 0) {
			month = "JAN";
		}

		if (dateInput == 1) {
			month = "FEB";
		}

		if (dateInput == 2) {
			month = "MAR";
		}
		if (dateInput == 3) {
			month = "APR";
		}

		if (dateInput == 4) {
			month = "MAY";
		}
		if (dateInput == 5) {
			month = "JUN";
		}
		if (dateInput == 6) {
			month = "JUL";
		}
		if (dateInput == 7) {
			month = "AUG";
		}
		if (dateInput == 8) {
			month = "SEP";
		}
		if (dateInput == 9) {
			month = "OCT";
		}
		if (dateInput == 10) {
			month = "NOV";
		}
		if (dateInput == 11) {
			month = "DEC";
		}
		return month;
	}

}
