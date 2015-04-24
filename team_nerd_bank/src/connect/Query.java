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
	public static boolean setPayee(String ref, String name, int acc_no, String sort_code, int acc_ref) {
		try {

			sql = "INSERT INTO the_bank.Payee (Reference, Name, Account_Number, Sort_code, assigned_account) VALUES (?, ?, ?, ?, ?)";
			statement = Connect_DB.pStatement(sql);

			statement.setString(1, ref);
			statement.setString(2, name);
			statement.setInt(3, acc_no);
			statement.setString(4, sort_code);
			statement.setInt(5, acc_ref);

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
	public static ResultSet getPayeeDetails(int pin) {

		try {

			sql = "SELECT Reference, Name, Account_Number, Payee.Sort_Code FROM the_bank.Payee "
					+ "INNER JOIN  the_bank.Account ON Account.account_num = Payee.assigned_account "
					+ "INNER JOIN the_bank.Member ON Member.customer_ID = Account.customer_ID WHERE Member.auto_ID = ?";
			statement = Connect_DB.pStatement(sql);
			statement.setInt(1, pin);

			result = statement.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
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

	/**
	 * Method to get names of all Payees associated with account
	 * 
	 * @param pin
	 * @return ArrayList<String> names
	 */
	public static ArrayList<String> getPayeesNames(int pin) {

		ArrayList<String> names = new ArrayList<String>();

		try {

			sql = "SELECT Name FROM the_bank.Payee INNER JOIN the_bank.Account ON " + "Payee.assigned_account = Account.account_num "
					+ "INNER JOIN the_bank.Member ON Member.customer_ID = Account.customer_ID WHERE Member.auto_ID = ?";
			statement = Connect_DB.pStatement(sql);

			statement.setInt(1, pin);
			result = statement.executeQuery();

			while (result.next()) {

				names.add(result.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return names;
	}

	/**
	 * Method to get the last seven days transactions associated with the user
	 * 
	 * @param pin
	 * @return ResultSet result
	 */
	public static ResultSet getSummary(int pin) {

		Calendar date = Calendar.getInstance();
		Calendar past = Calendar.getInstance();
		past.add(Calendar.DATE, -7);

		try {
			sql = "SELECT Transaction.type, Transaction.account_num, Account.sort_code, Account.balance, Transaction.amount "
					+ "FROM the_bank.Transaction INNER JOIN the_bank.Account ON Transaction.account_num = Account.account_num "
					+ "INNER JOIN the_bank.Member ON Member.customer_ID = Account.customer_ID "
					+ "WHERE Transaction.date BETWEEN ? AND ? AND Member.auto_ID = ?";
			statement = Connect_DB.pStatement(sql);

			statement.setDate(1, new java.sql.Date(past.getTimeInMillis()));
			statement.setDate(2, new java.sql.Date(date.getTimeInMillis()));
			statement.setInt(3, pin);

			result = statement.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Method to return any account numbers associated with the user
	 * 
	 * @param pin
	 * @return ArrayList<String> list
	 */
	public static ArrayList<String> getAccountNumbers(int pin) {

		ArrayList<String> list = new ArrayList<String>();

		try {
			sql = "SELECT Account.account_num FROM the_bank.Account INNER JOIN the_bank.Member ON Account.customer_ID "
					+ "= Member.customer_ID WHERE Member.auto_ID = ?";
			statement = Connect_DB.pStatement(sql);

			statement.setInt(1, pin);

			result = statement.executeQuery();
			while (result.next()) {

				list.add(String.valueOf(result.getInt(1)));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		for (int j = 0; j < list.size(); j++) {
			
			System.out.println(list.get(j));
		}
		
		return list;
	}
	
	/**
	 * Method to check that the user has sufficient funds before transfer
	 * @param amount
	 * @param accout
	 * @param pin
	 * @return boolean allGood
	 */
	public static boolean checkBalance(double amount, int accout, int pin) {
		
		boolean allGood = false;
		double balance = 0;
		
		try {

			sql = "SELECT balance FROM the_bank.Account "
					+ "INNER JOIN the_bank.Member ON Account.customer_ID = Member.customer_ID "
					+ "WHERE Member.auto_ID = ? AND account_num = ?";
			statement = Connect_DB.pStatement(sql);
			
			statement.setInt(1, pin);
			statement.setInt(2, accout);

			result = statement.executeQuery();

			while (result.next()) {

				balance = result.getDouble(1);
			}
			
			// check that there is sufficient funds
			if (balance > amount) {
				
				allGood = true;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		return allGood;
	}
	
	/**
	 * Method to subtract transfer amount from users account
	 * @param amount
	 * @param accout
	 * @return boolean jobDone
	 */
	public static boolean subtractBalance(double amount, int accout) {
		
		boolean jobDone = false;
		int finished;
		
		try {

			sql = "UPDATE the_bank.Account as acc SET balance = ? "
					+ "WHERE account_num = ?";
			statement = Connect_DB.pStatement(sql);
			
			statement.setDouble(1, amount);
			statement.setInt(2, accout);

			finished = statement.executeUpdate();
			
			if (finished == 1) {
				
				jobDone = true;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		return jobDone;
	}
}
