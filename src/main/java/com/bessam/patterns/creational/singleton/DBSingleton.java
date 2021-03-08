package com.bessam.patterns.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author bessam on 08/03/2021
 */

public class DBSingleton {

	//(for threadsafety) volatile will make it thread safe it will assure that the instance will stay singleton no matter what
	private static volatile DBSingleton instance = null;
	private static volatile Connection conn = null;

	//(for threadsafety) to not allow the creation from outside
	private DBSingleton() {

		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		// to make sure that it wont be reinstanciated through different things in the JVM like reflection ...
		if (instance != null)
			throw new RuntimeException("Use getInstance() method to create ");

		if (conn != null) {
			throw new RuntimeException("Use getConnection() method to create");
		}
	}

	// to make it lazy loaded
	//it will make the app load fast and perform better
	public static DBSingleton getInstance() {
		if (instance == null) {// for thread safety if a thread get here it will be locked
			synchronized (DBSingleton.class) { // for thread safety
				if (instance == null) // for thread safety if a thread get here it will lock the other
					instance = new DBSingleton();
			}
		}
		return instance;
	}


	public Connection getConnection() {
		if (conn == null) {
			synchronized (DBSingleton.class) {
				if (conn == null) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
						conn = DriverManager.getConnection(dbUrl);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
}
