package com.techprimers.security.jwtsecurity.Dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectionProvider {
	protected static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void createConnection(String url, String userName, String password) {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println("Error ::Creating Connection With DB");// In Server We should Use logger.
		}
	}
}
