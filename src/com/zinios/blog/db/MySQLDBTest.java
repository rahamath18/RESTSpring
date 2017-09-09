package com.zinios.blog.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDBTest {

	public static void main(String[] args) {
		
		System.out.println("max blog id : " + getMaxId());
		//testDBConnection();
		
	}
	
	public static void testDBConnection() {
		String url = "jdbc:mysql://localhost:3306/ziniosblog";
		String username = "root";
		String password = "password";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID FROM ziniosblog.ZBLOG_BLOG");
			while(rs.next())
				System.out.println(rs.getInt("ID"));
			rs.close();
			stmt.close();
			connection.close();
		    
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	 public static int getMaxId() {
	    	try {
				Connection connection = new DBConnectionUtil().getDBConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT max(ID) as ID FROM ZBLOG_BLOG");
				while(rs.next()) {
					return rs.getInt(1) + 1;
				}
				
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return -1;
	    }


}
