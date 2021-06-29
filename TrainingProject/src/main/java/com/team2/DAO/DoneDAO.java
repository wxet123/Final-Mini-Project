package com.team2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.team2.model.Done;

public class DoneDAO {

	public static int updateStatus(Done training_id) {

		String updateTrainingIdStatus = "update createtraining set status = 2 WHERE  training_id = ?;";
		

		try
		
		(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(updateTrainingIdStatus)) {
			ps.setInt(1, training_id.getTraining_id());

			int rs = ps.executeUpdate();

			return rs;

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}





	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/elearning?useSSL=false&useTimezone=true&serverTimezone=UTC", "root",
					"Neverwinter132!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
