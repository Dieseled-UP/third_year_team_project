/*
* 7 Mar 2015
* am_nerd_bank
* 19:32:07
*/
package people;


public class Payee {

	private String reference;
	private String name;
	private static int payee_id;
	private int payee_acc_no;
	private String payee_code;
	
	/**
	 * Default constructor
	 */
	public Payee() {
		super();
	}
	
	/**
	 * 
	 * @param reference
	 * @param name
	 */
	public Payee(String reference, String name, int payee_acc_no, String payee_code) {
		
		this.payee_id = payee_id++;
		this.reference = reference;
		this.name = name;
		this.payee_acc_no = payee_acc_no;
		this.payee_code = payee_code;
		
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
	
		return reference;
	}

	/**
	 * @return the name
	 */
	public String getName() {
	
		return name;
	}

	/**
	 * @return the payee_id
	 */
	public int getPayeeId() {
	
		return payee_id;
	}
	
	/**
	 * @return the payee_acc_no
	 */
	public int getPayeeAccNo() {
	
		return payee_acc_no;
	}
	
	/**
	 * @return the payee_code
	 */
	public String getPayeeCode() {
	
		return payee_code;
	}
	

	/**
	 * @param payee_id the payee_id to set
	 */
	public static void setPayee_id(int payee_id) {
		Payee.payee_id = payee_id;
	}

	/**
	 * @param payee_acc_no the payee_acc_no to set
	 */
	public void setPayee_acc_no(int payee_acc_no) {
		this.payee_acc_no = payee_acc_no;
	}

	/**
	 * @param payee_code the payee_code to set
	 */
	public void setPayee_code(String payee_code) {
		this.payee_code = payee_code;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
	
		this.reference = reference;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
	
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Payee [reference=" + reference + ", name=" + name + "]";
	}
	
}