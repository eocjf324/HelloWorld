package co.yedam.bank;

//기능구현
public class BankApp {

	//싱글톤 방식.
	private static BankApp instance = new BankApp();
	
	//필드
	Account[] account;
	int cnt = 0;
	Account ac = new Account();
	
	private BankApp() {
		account = new Account[10];
	}
	
	public static BankApp getInstance() {
		return instance;
	}

	void registerAccount(Account ac) {
		
		account[cnt++] = ac;
	}
//	void registerAccount(String num, String name, int deposit) {
//		account[cnt++] = new Account(num,name,deposit);
//	}
	

	int deposit(String num, int deposit) {
	
		for (int i = 0; i < account.length; i++) {
			if (num.equals(account[i].account)) {
				deposit += ac.getBalance();
				ac.setBalance(deposit);
				
				account[i].balance = deposit;
				return 1;
			}
		}

		return 0;
	}







}
