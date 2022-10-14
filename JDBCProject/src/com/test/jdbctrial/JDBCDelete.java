package com.test.jdbctrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDelete {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trialschema","root","root1234");
			//PreparedStatement stmt = conn.prepareStatement("update userinfo set FirstName =?, LastName =? where UserId=?");
			
			PreparedStatement stmt2 = conn.prepareStatement("delete from userinfo where UserId=?");
			
			stmt2.setInt(1, 2);
			
			int i = stmt2.executeUpdate();
			
			System.out.println("Record deleted "+ i);
			
			conn.close();
			stmt2.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
