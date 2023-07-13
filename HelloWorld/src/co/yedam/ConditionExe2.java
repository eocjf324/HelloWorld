package co.yedam;

import java.util.Scanner;

public class ConditionExe2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("메뉴를 선택하세요(숫자를 입력)>> ");
			String menu = scan.nextLine();

			// switch,
			switch (Integer.parseInt(menu)) {
			case 1:
				login();
				break;
			case 2:
				logout();
				break;
			case 3:
				signup();
				break;
			default:
				break;
			}
		}
	}// end of main

	public static void login() {
		System.out.println("로그인메뉴입니다.");
	}

	public static void logout() {
		System.out.println("로그아웃메뉴입니다.");
	}

	public static void signup() {
		System.out.println("회원가입메뉴입니다.");
	}
}
