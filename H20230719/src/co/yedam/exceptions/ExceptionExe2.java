package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("이름>> ");
		String name = scan.nextLine();
		int age;

		while (true) {
			try {
				System.out.print("나이>> ");
				age = Integer.parseInt(scan.nextLine());
				break;

			} catch (NumberFormatException n) {
				System.out.println("숫자를 입력하세요.");
				continue;
			}
		}

		System.out.print("주소>> ");
		String addr = scan.nextLine();

		System.out.printf("이름은 %s, 나이는 %d, 주소는 %s", name, age, addr);

	}
}
