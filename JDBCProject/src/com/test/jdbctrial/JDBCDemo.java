package com.test.jdbctrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trialschema","root","root1234");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from userinfo");
			
			while(rs.next()) {
				System.out.print(rs.getString(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.println(rs.getString(3)+" ");
//				if("pramod".equals(rs.getString(2))) {
//					System.out.println("successfully logged in.....");
//					break;
//				}
			}
			
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
