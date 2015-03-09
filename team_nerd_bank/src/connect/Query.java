/*
 * 3 Mar 2015
 * team_nerd_bank
 * 18:40:39
 */
package connect;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;




import java.util.ArrayList;

import people.Customer;
import net.proteanit.sql.DbUtils;

public class Query {

	private static String sql = null;
	private static Customer cust;
	private static ResultSet result;
//	private static ArrayList<Customer> list = new ArrayList<>();

	/**
	 * Method to query the database and bring back customer details based on account number
	 * @param number
	 * @return cust
	 */
	public static Customer getDetails(int number) {

		sql = "SELECT * FROM the_bank.Customer" + " INNER JOIN Account"
				+ " ON Account.customer_ID = Customer.customer_ID"
				+ " WHERE Account.account_num = '" + number + "';";

		try {

			result = Connect_DB.pStatement(sql).executeQuery();

			while (result.next()) {
				
				cust = new Customer(result.getString(2), result.getString(3), result.getDate(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8));
			}

			// Close the connection
			Connect_DB.finish();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return cust;
	}
	
	/**
	 * Method to query the database and return the user sort code and account number
	 * @param number
	 * @return
	 */
	public static String[] getAccount(int number) {

		String[] account = new String[2];

		sql = "SELECT * FROM the_bank.Account"
				+ " WHERE Account.account_num = '" + number + "';";
		
		try {

			result = Connect_DB.pStatement(sql).executeQuery();

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

		sql = "SELECT auto_id FROM the_bank.Member"
				+ " WHERE Member.auto_id = '" + number + "';";
		
		try {
			
			result = Connect_DB.pStatement(sql).executeQuery();
			
			while (result.next()) {
				
				if (result.getInt(1) == number) {
					
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	/*public static return_type name() {
		
		sql = "select CONCAT(First_Name,', ', Last_Name) as Name, Account_No as \"Account No\", Reference from Payee";
		ResultSet result;
		
		try {
			result = Connect_DB.pStatement(sql).executeQuery();
			
			while (result.next()) {
				
			}
			
			// Close the connection
			Connect_DB.finish();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
