package co.yedam.bank;

import java.util.Scanner;

//사용자화면
public class BankAppExe {
	static Scanner scan = new Scanner(System.in);
	//static BankApp app = new BankApp();
	static BankApp app = BankApp.getInstance();
	
	
	public static void main(String[] args) {
		init();
		app();
	}

	
	public static void app() {
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.입금 3.출금 4.잔액 5.계좌목록 6.종료");
			System.out.print("번호입력>");
			int menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				System.out.print("계좌번호입력>");
				String num = scan.nextLine();
				System.out.print("예금주>");
				String name = scan.nextLine();
				System.out.print("입금액>");
				int deposit = Integer.parseInt(scan.nextLine());
			
				app.registerAccount(new Account(num,name,deposit));
								
			} else if (menu == 2) {
				System.out.print("계좌번호입력>");
				String num = scan.nextLine();
				System.out.print("입금액>");
				int deposit = Integer.parseInt(scan.nextLine());
				int balance =app.deposit(num, deposit);
				System.out.println("잔고 :" +balance);
				
			} else if (menu == 3) {

			} else if (menu == 4) {

			} else if (menu == 5) {
				for(int i=0 ; i< app.account.length; i++) {
					if(app.account[i] != null) {
						System.out.printf("계좌번호: %s, 예금주: %s, 잔고: %d\n", app.account[i].getAccount(),app.account[i].getAcoountName(), app.account[i].getBalance());
					}
				}
			} else if (menu == 6) {
				run = false;
				System.out.println("종료");
			}
		}
	}
	private static void init() {
		app.registerAccount(new Account("111","김길동",10000));
		app.registerAccount(new Account("222","박길동",60000));
		app.registerAccount(new Account("333","홍길동",30000));
	}
}
