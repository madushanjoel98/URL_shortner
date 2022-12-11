package com.url.controllers.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() throws SQLException {
		Connection con = null;

		String dbUrl = "jdbc:mysql://localhost:3306/url_shortner";
		String dbUser = "root";
		String dbPass = "1234";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con =   (Connection) DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (Exception e) {
			con =   (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", dbUser, dbPass);
			 System.out.println("Error in DatabaseConnection.getConnection : "+e.toString());
		}
	System.out.println("*** CONNECTION ****" + con);
		return (Connection) con;
	}
}
