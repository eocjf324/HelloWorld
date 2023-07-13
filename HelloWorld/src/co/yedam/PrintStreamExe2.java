package co.yedam;

import java.util.Scanner;

public class PrintStreamExe2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("값>>> ");
		String result = scan.nextLine();
		System.out.println("입력값: " + result);
		
		int a = Integer.parseInt(result);
		System.out.println(a * 2);
	}
}
