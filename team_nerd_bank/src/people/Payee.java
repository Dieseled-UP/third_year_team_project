/*
* 7 Mar 2015
* am_nerd_bank
* 19:32:07
*/
package people;


public class Payee {

	private String reference;
	private String name;
	
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
	public Payee(String reference, String name) {
		
		this.reference = reference;
		this.name = name;
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