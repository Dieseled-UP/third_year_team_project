/*
 * 7 Mar 2015
* team_nerd_bank
* 19:39:39
 */
package people;


public class PayAccount extends Payee {
	
	private String IBAN;
	private String BIC;
	
	/**
	 * Default constructor
	 */
	public PayAccount() {

		super();
	}
	
	/**
	 * @param reference
	 * @param name
	 */
	public PayAccount(String reference, String name) {

		super(reference, name);
	}

	/**
	 * @return the iBAN
	 */
	public String getIBAN() {
	
		return IBAN;
	}

	/**
	 * @return the bIC
	 */
	public String getBIC() {
	
		return BIC;
	}

	/**
	 * @param iBAN the iBAN to set
	 */
	public void setIBAN(String iBAN) {
	
		IBAN = iBAN;
	}

	/**
	 * @param bIC the bIC to set
	 */
	public void setBIC(String bIC) {
	
		BIC = bIC;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "PayAccount [IBAN=" + IBAN + ", BIC=" + BIC + "]";
	}
}
