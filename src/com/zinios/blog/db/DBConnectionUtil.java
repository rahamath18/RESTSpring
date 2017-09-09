package com.zinios.blog.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {
	
	public Connection getDBConnection() {
		String url = "jdbc:mysql://localhost:3306/ziniosblog";
		String username = "root";
		String password = "password";

		System.out.println("Connecting database...");

		try  {
			Connection connection = DriverManager.getConnection(url, username, password);
		    System.out.println("Database connected!!!");
			return connection;
		    
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
	}

}
