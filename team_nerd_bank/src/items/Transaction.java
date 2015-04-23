/*
* 23 Apr 2015
* team_nerd_bank
* 01:54:03
*/
package items;

public class Transaction {

	private String type;
	private int account_num;
	private String sort_code;
	private double balance;
	private double amount;
	
	public Transaction() {
		
		super();
	}
	
	public Transaction(String type, int account_num, String sort_code, double balance, double amount) {
		
		this.type = type;
		this.account_num = account_num;
		this.sort_code = sort_code;
		this.balance = balance;
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAccount_num() {
		return account_num;
	}

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	public String getSort_code() {
		return sort_code;
	}

	public void setSort_code(String sort_code) {
		this.sort_code = sort_code;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [type=" + type + ", account_num=" + account_num + ", sort_code=" + sort_code + ", balance=" + balance
				+ ", amount=" + amount + "]";
	}
}
