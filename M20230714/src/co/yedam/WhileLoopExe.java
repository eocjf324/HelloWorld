package co.yedam;

import java.util.Scanner;

public class WhileLoopExe {
	static Scanner scan = new Scanner(System.in);
	static int balance = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 은행: 1.입금 2.출금 3.잔액 4.종료
		// 제한 금액 : 10만원, 5만원 + 5.2만원 x
		boolean run = true;

		while (run) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				deposit();break;
			case 2:
				withdraw();break;
			case 3:
				check();break;
			case 4:
				run = false;break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
		System.out.println("end of prog");

	}

	public static void deposit() {
		System.out.print("입금액을 입력>>");
		int deposit = Integer.parseInt(scan.nextLine());
		if (balance + deposit <= 100000) {
			balance += deposit;
			System.out.println("입금되었습니다.");
		} else {
			System.out.println("제한 금액 10만원을 초과했습니다.");
		}
	}

	public static void withdraw() {
		System.out.print("출금액을 입력>>");
		int withdraw = Integer.parseInt(scan.nextLine());
		if (balance >= withdraw) {
			balance -= withdraw;
		} else {
			System.out.println("잔고가 부족합니다.");
		}

	}

	public static void check() {
		System.out.printf("현재 잔액은 %d입니다.\n", balance);
	}

}
