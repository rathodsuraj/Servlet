package com.servlet.jdbc.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JdbcUtil {
	
	private static Connection con;
	private static Statement stmt;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdemo","root","root");
	return con;
	}
	public static Statement getStatement() throws SQLException {
	
		stmt=(Statement) con.createStatement();
		return stmt;
	}

}
