package co.yedam.bank;

public class Account {
	
	String account;
	String acoountName;
	int balance;
	
	Account(){}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAcoountName() {
		return acoountName;
	}

	public void setAcoountName(String acoountName) {
		this.acoountName = acoountName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Account(String account, String acoountName, int balance) {
		super();
		this.account = account;
		this.acoountName = acoountName;
		this.balance = balance;
	}
	
	
	
}
