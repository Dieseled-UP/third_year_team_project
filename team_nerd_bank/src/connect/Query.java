/*
 * 3 Mar 2015
 * team_nerd_bank
 * 18:40:39
 */
package connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import people.Customer;
import people.Payee;

//import java.util.ArrayList;

/**
 * @author Denis Bourne L00099023 15 Apr 2015
 */
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

			sql = "SELECT * FROM the_bank.Customer INNER JOIN Account ON Account.customer_ID = Customer.customer_ID"
					+ " WHERE Account.account_num = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, number);

			result = statement.executeQuery();

			while (result.next()) {

				cust = new Customer(result.getInt(1), result.getString(2), result.getString(3), result.getDate(4), result.getString(5),
						result.getString(6), result.getString(7), result.getString(8));
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

			sql = "SELECT * FROM the_bank.Account WHERE Account.account_num = ?";
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

	/**
	 * Method to add new member details to the database
	 * 
	 * @param list
	 * @param id
	 */
	public static boolean setPinPass(String auto, byte[] pin, byte[] pass, int id) {

		try {

			sql = "INSERT INTO the_bank.Member VALUES (?, ?, ?, ?)";
			statement = Connect_DB.pStatement(sql);

			statement.setString(1, auto);
			statement.setBytes(2, pin);
			statement.setBytes(3, pass);
			statement.setInt(4, id);

			int done = statement.executeUpdate();

			if (done == 1) {

				return true;
			}

			// Close the connection
			Connect_DB.finish();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Method to query the database to return the auto generated pin
	 * 
	 * @param number
	 * @return boolean
	 */
	public static boolean getAutoID(String number) {

		boolean correct = false;
		try {

			sql = "SELECT auto_id FROM the_bank.Member WHERE Member.auto_id = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setString(1, number);

			result = statement.executeQuery();

			while (result.next()) {

				if (result.getString(1).equalsIgnoreCase(number)) {

					correct = true;
				}
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return correct;
	}

	/**
	 * Method to query the database and return the user pin
	 * 
	 * @param num
	 * @return byte[] pin
	 */
	public static byte[] getDBPin(String num) {

		byte[] pin = null;

		// For testing purposes
		System.out.println(num);

		try {

			sql = "SELECT pin FROM the_bank.Member WHERE auto_ID = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setString(1, num);

			result = statement.executeQuery();
			while (result.next()) {

				pin = result.getBytes(1);
			}

			// Close the connection
			Connect_DB.finish();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pin;
	}

	/**
	 * Method to query the database and return the user password
	 * 
	 * @param num
	 * @return byte[] pin
	 */
	public static byte[] getDBPass(String num) {

		byte[] pass = null;

		// For testing purposes
		System.out.println(num);

		try {

			sql = "SELECT passw FROM the_bank.Member WHERE auto_ID = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setString(1, num);

			result = statement.executeQuery();
			while (result.next()) {

				pass = result.getBytes(1);
			}

			// Close the connection
			Connect_DB.finish();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pass;
	}

	/**
	 * Method to return the user name on login this will be displayed during
	 * session
	 * 
	 * @param pin
	 * @return String name
	 */
	public static String getUserName(int pin) {

		String name = null;

		try {

			sql = "SELECT f_name, s_name FROM the_bank.Customer INNER JOIN Member ON Customer.customer_ID"
					+ " = Member.customer_ID WHERE Member.auto_ID = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, pin);

			result = statement.executeQuery();
			while (result.next()) {

				name = result.getString(1);
				name += " ";
				name += result.getString(2);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return name;
	}

	/**
	 * Method to insert payee details into database
	 * 
	 * @return boolean
	 */
	public static boolean setPayee(int id, String ref, String name, int acc_no, String sort_code, int acc_ref) {
		try {

			sql = "INSERT INTO the_bank.Payee VALUES (?, ?, ?, ?, ?, ?)";
			statement = Connect_DB.pStatement(sql);

			statement.setInt(1, id);
			statement.setString(2, ref);
			statement.setString(3, name);
			statement.setInt(4, acc_no);
			statement.setString(5, sort_code);
			statement.setInt(6, acc_ref);

			int done = statement.executeUpdate();

			if (done == 1) {

				return true;
			}

			// Close the connection
			Connect_DB.finish();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// Method to get payee details
	// Returns the ResultSet as a string
	// To be used in PopulateTable() method in Payees class
	public static ArrayList<Payee> getPayeeDetails(int pin) {

		ArrayList<Payee> temPayees = new ArrayList<Payee>();

		try {

			sql = "SELECT Reference, Name, Account_Number, Payee.Sort_Code FROM the_bank.Payee, Account, Member WHERE Account.account_num"
					+ " = Payee.assigned_account AND Member.customer_ID = Account.customer_ID AND Member.auto_ID = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, pin);

			result = statement.executeQuery();
			while (result.next()) {

				temPayees.add(new Payee(result.getString(2), result.getString(3), result.getInt(4), result.getString(5)));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return temPayees;
	}

	// Method to remove payee from database
	public static void removePayeeDatabase(int account, String sortCode) {
		sql = "DELETE from the_bank.Payee where Account_Number = ? AND Sort_Code = ?";
		statement = Connect_DB.pStatement(sql);

		try {
			statement.setInt(1, account);
			statement.setString(2, sortCode);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<String> getSummary(int pin) {

		ArrayList<String> temp = new ArrayList<String>();

		Calendar date = Calendar.getInstance();
		Calendar past = Calendar.getInstance();
		past.add(Calendar.DATE, -7);

		try {
			sql = "SELECT  FROM Transaction where date BETWEEN ? AND ?";
			statement = Connect_DB.pStatement(sql);

			statement.setDate(1, new java.sql.Date(date.getTimeInMillis()));
			statement.setDate(1, new java.sql.Date(past.getTimeInMillis()));

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return temp;
	}
}
