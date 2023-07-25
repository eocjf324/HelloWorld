package co.yedam.Bank;

import java.io.Serializable;

public class Bank implements Serializable {
	String account;
	String name;
	int balance;
	String password;
	String balance2;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Bank(String account, String name, String password, int balance) {
		super();
		this.account = account;
		this.name = name;
		this.password = password;
		this.balance = balance;
		
	}
	public Bank(String balance2) {
		this.balance2 = balance2;
	}

	public Bank(String account, String name, String password) {
		this.account = account;
		this.name = name;
		this.password = password;
		this.balance = 0;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}
	public String getBalance2() {
		return balance2;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "계좌번호 : " + account + ", 이름: " + name + ", 잔고 : " + balance;
	}

}
