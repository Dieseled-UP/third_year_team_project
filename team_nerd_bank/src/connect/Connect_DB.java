/*
 * 3 Mar 2015
 * team_nerd_bank
 * 18:40:39
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect_DB {

	// declare variables
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://52.16.53.121/the_bank";
	private static final String DB_USER = "admin";
	private static final String DB_PASSWORD = "password";
	private static Connection con = null;
	private static PreparedStatement statement = null;

	/**
	 * Method to make a connection to the database
	 * 
	 * @return Connection con
	 */
	public static Connection getConnection() {

		System.setProperty(DB_DRIVER, "");

		try {
			// Register JBDC driver
			Class.forName(DB_DRIVER);

			// Open connection
			con = (Connection) DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

			// Tell user if successful
			System.out.println("Connection successful...");

		} catch (ClassNotFoundException e1) {

			// Warn user the driver could not be found
			System.out.println("MySql JDBC Driver not found");
			e1.printStackTrace();

		} catch (Exception e) {

			// Tell user if unsuccessful
			System.out.println("Database Connection Unsuccessful... Fail");
		}

		return con;
	}

	/**
	 * Method to take a string and make it a SQL PreparedStatement
	 * 
	 * @param statementIn
	 * @return PreparedStatement statement
	 */
	public static PreparedStatement pStatement(String statementIn) {

		try {

			PreparedStatement statement = (PreparedStatement) getConnection().prepareStatement(
					statementIn);
			return statement;
		} catch (SQLException e) {

			System.out.println("Please check SQL syntax");
			return statement;
		}
	}

	/**
	 * Method to close the connection
	 * 
	 * @throws SQLException
	 */
	public static void finish() throws SQLException {

		con.close();
	}

	/**
	 * Method to check that the jdbc driver is connected
	 * 
	 * @return boolean result
	 */
	public static String dBExists() {

		boolean result = false;

		if (getConnection() == null) {

			result = false;

		} else {

			result = true;
		}

		return String.valueOf(result);
	}
}
