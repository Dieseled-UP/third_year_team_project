/*
 * 3 Mar 2015
 * team_nerd_bank
 * 18:40:39
 */
package connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.ArrayList;

import people.Customer;

public class Query {

	private static String sql = null;
	private static Customer cust;
	private static ResultSet result;
	private static PreparedStatement statement;

	// private static ArrayList<Customer> list = new ArrayList<>();

	/**
	 * Method to query the database and bring back customer details based on
	 * account number
	 * 
	 * @param number
	 * @return cust
	 */
	public static Customer getDetails(int number) {

		try {

			sql = "SELECT * FROM the_bank.Customer" + " INNER JOIN Account"
					+ " ON Account.customer_ID = Customer.customer_ID"
					+ " WHERE Account.account_num = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, number);

			result = statement.executeQuery();

			while (result.next()) {

				cust = new Customer(result.getString(2), result.getString(3), result.getDate(4),
						result.getString(5), result.getString(6), result.getString(7),
						result.getString(8));
			}

			// Close the connection
			Connect_DB.finish();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return cust;
	}

	/**
	 * Method to query the database and return the user sort code and account
	 * number
	 * 
	 * @param number
	 * @return
	 */
	public static String[] getAccount(int number) {

		String[] account = new String[2];

		try {

			sql = "SELECT * FROM the_bank.Account" + " WHERE Account.account_num = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, number);

			result = statement.executeQuery();

			while (result.next()) {

				account[0] = String.valueOf(result.getInt(1));
				account[1] = result.getString(2);
			}

			// Close the connection
			Connect_DB.finish();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return account;
	}

	public static boolean getAutoID(int number) {

		try {

			sql = "SELECT auto_id FROM the_bank.Member WHERE Member.auto_id = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, number);

			result = statement.executeQuery();

			while (result.next()) {

				if (result.getInt(1) == number) {

					return true;
				}
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return false;
	}

	public static ArrayList<String> getLogin(int num) {

		ArrayList<String> temp = new ArrayList<>();
		
		try {
			
			sql = "SELECT pin, password FROM the_bank.Member WHERE auto_ID = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, num);
			
			
			result = statement.executeQuery();
			result.next();
			
			temp.add(String.valueOf(result.getInt("pin")));
			temp.add(result.getString("password"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return temp;
	}

}
