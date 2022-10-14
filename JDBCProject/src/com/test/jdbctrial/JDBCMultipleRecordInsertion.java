package com.test.jdbctrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMultipleRecordInsertion {
	String id = null, fname = null, lname = null;

	Connection conn = null;
	PreparedStatement ps = null;

	public void insertData(String lname, String fname, String mobno) {
		try {
			ConnectionClass connection = new ConnectionClass();
			conn = connection.getConnection();
			ps = conn.prepareStatement("insert into student(LastName,FirstName,MOBNO)values(?,?,?)");
			ps.setString(1, lname);
			ps.setString(2, fname);
			ps.setString(3, mobno);
			int i = ps.executeUpdate();
			System.out.println("Record is insert successufully " + i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void doProcess() {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 5; i++) {
			System.out.println("Enter user last Name");
			id = sc.next();
			System.out.println("Enter first Name");
			fname = sc.next();
			System.out.println("Enter Mob no");
			lname = sc.next();
			JDBCMultipleRecordInsertion thisclass = new JDBCMultipleRecordInsertion();
			thisclass.insertData(id, fname, lname);
		}
	}

	public static void main(String[] args) {

		JDBCMultipleRecordInsertion obj = new JDBCMultipleRecordInsertion();
		obj.doProcess();
	}

}
