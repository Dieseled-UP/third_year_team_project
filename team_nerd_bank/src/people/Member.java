/*
* 9 Mar 2015
* team_nerd_bank
* 19:48:49
*/
package people;

import java.sql.Date;


public class Member extends Customer {

	private int autoID;
	private int pin;
	private String pass;
	
	/**
	 * 
	 */
	public Member() {

		super();
	}
	
	/**
	 * @param name
	 * @param surname
	 * @param dob
	 * @param address
	 * @param email
	 * @param telPhone
	 * @param mobile
	 */
	public Member(int id, String name, String surname, Date dob, String address, String email,
			String telPhone, String mobile) {

		super(id, name, surname, dob, address, email, telPhone, mobile);
	}

	
	/**
	 * @return the autoID
	 */
	public int getAutoID() {
	
		return autoID;
	}

	
	/**
	 * @return the pin
	 */
	public int getPin() {
	
		return pin;
	}

	
	/**
	 * @return the pass
	 */
	public String getPass() {
	
		return pass;
	}

	
	/**
	 * @param autoID the autoID to set
	 */
	public void setAutoID(int autoID) {
	
		this.autoID = autoID;
	}

	
	/**
	 * @param pin the pin to set
	 */
	public void setPin(int pin) {
	
		this.pin = pin;
	}

	
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
	
		this.pass = pass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Member [autoID=" + autoID + ", pin=" + pin + ", pass=" + pass + "]";
	}
	
	
}
