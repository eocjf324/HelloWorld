package co.yedam.Bank;

import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		AccountManage am = new AccountManage();

		boolean run = true;
		System.out.println("은행계좌관리");
		while (run) {
			System.out.println("1.계좌생성 2.입금 3.출금 4.계좌조회 5.거래내역조회 6.종료");
			System.out.print("번호 입력>");
			int menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				am.addAccount();
			} else if (menu == 2) {
				am.deposit();
			} else if (menu == 3) {
				am.withdraw();
			} else if (menu == 4) {
				am.show();
			} else if (menu == 5) {
				am.dealList();
			} else if (menu == 6) {
				am.storeTofile();
				run = false;
			}

		}

	}
}
