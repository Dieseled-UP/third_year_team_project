/*
* 6 Mar 2015
* team_nerd_bank
* 00:33:13
*/
package people;

import java.sql.Date;


public class Customer {
	
	private int id;
	private String name;
	private String surname;
	private Date dob;
	private String address;
	private String email;
	private String telPhone;
	private String mobile;
	
	/**
	 * Default constructor
	 */
	public Customer() {
		super();
	}
	
	/**
	 * User defined constructor
	 * @param name
	 * @param surname
	 * @param dob
	 * @param email
	 * @param telPhone
	 * @param mobile
	 */
	public Customer(int id, String name, String surname, Date dob, String address, String email, String telPhone, String mobile) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.telPhone = telPhone;
		this.mobile = mobile;
	}

	/**
	 * Method to get customer id
	 * @return id
	 */
	public int getId() {
		
		return id;
	}

	/**
	 * Method to get customer name
	 * @return name
	 */
	public String getName() {
	
		return name;
	}

	/**
	 * Method to set customer name
	 * @param name
	 */
	public void setName(String name) {
	
		this.name = name;
	}

	/**
	 * Method to get customer surname
	 * @return surname
	 */
	public String getSurname() {
	
		return surname;
	}

	/**
	 * Method to set customer surname
	 * @param surname
	 */
	public void setSurname(String surname) {
	
		this.surname = surname;
	}

	/**
	 * Method to get customer dob
	 * @return dob
	 */
	public Date getDob() {
	
		return dob;
	}

	/**
	 * Method to set customer dob
	 * @param dob
	 */
	public void setDob(Date dob) {
	
		this.dob = dob;
	}

	/**
	 * Method to get customer address
	 * @return address
	 */
	public String getAddress() {
	
		return address;
	}

	/**
	 * Method to set customer address
	 * @param address
	 */
	public void setAddress(String address) {
	
		this.address = address;
	}

	/**
	 * Method to get customer email
	 * @return email
	 */
	public String getEmail() {
	
		return email;
	}

	/**
	 * Method to set customer email
	 * @param email
	 */
	public void setEmail(String email) {
	
		this.email = email;
	}

	/**
	 * Method to get customer tel-Phone number
	 * @return telPhone
	 */
	public String getTelPhone() {
	
		return telPhone;
	}

	/**
	 * Method to set customer tel-Phone number
	 * @param telPhone
	 */
	public void setTelPhone(String telPhone) {
	
		this.telPhone = telPhone;
	}

	/**
	 * Method to get customer mobile number
	 * @return mobile
	 */
	public String getMobile() {
	
		return mobile;
	}

	/**
	 * Method to set customer mobile number
	 * @param mobile
	 */
	public void setMobile(String mobile) {
	
		this.mobile = mobile;
	}

	/**
	 * Method to return customer details in String format
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", address=" + address + ", email="
				+ email + ", telPhone=" + telPhone + ", mobile=" + mobile + "]";
	}
}
