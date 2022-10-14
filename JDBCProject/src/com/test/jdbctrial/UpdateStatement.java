package com.test.jdbctrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trialschema","root","root1234");
			PreparedStatement stmt = conn.prepareStatement("update userinfo set FirstName =?, LastName =? where UserId=?");
			
			PreparedStatement stmt2 = conn.prepareStatement("update userinfo set FirstName=? LastName=? where UserId=?");
			
			stmt.setString(1, "Pradyum");
			stmt.setString(2, "Salunke");
			stmt.setString(3, "125");
			
			int i = stmt.executeUpdate();
			
			System.out.println("Record is updated successufully "+ i);
			
			conn.close();
			stmt.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
