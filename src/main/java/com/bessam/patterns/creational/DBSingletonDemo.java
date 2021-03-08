package com.bessam.patterns.creational;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author bessam on 08/03/2021
 */

public class DBSingletonDemo {

	public static void main(String[] args){
		DBSingleton instance = DBSingleton.getInstance();
		System.out.println(instance);

		Connection connection = instance.getConnection();


		Statement sta;
		try {
			sta = connection.createStatement();
			int count = sta
					.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
							+ " City VARCHAR(20))");
			System.out.println("Table created.");
			sta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
