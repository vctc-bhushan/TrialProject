package com.test.jdbctrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBCDynamicDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trialschema","root","root1234");
			PreparedStatement stmt = conn.prepareStatement("insert into userinfo(UserId,FirstName,LastName)values(?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter id");
			String id = sc.nextLine();
			System.out.println("Please enter first name");
			String firstname = sc.nextLine();
			System.out.println("Please enter last name");
			String lastname = sc.nextLine();
			stmt.setString(1, id);
			stmt.setString(2, firstname);
			stmt.setString(3, lastname);
			
			int j = stmt.executeUpdate();
			
			System.out.println("Record is inserted."+ j);
			
//			while(rs.next()) {
//				System.out.print(rs.getString(1)+" ");
//				System.out.print(rs.getString(2)+" ");
//				System.out.println(rs.getString(3)+" ");
////				if("pramod".equals(rs.getString(2))) {
////					System.out.println("successfully logged in.....");
////					break;
////				}
//			}
			
			conn.close();
			stmt.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
