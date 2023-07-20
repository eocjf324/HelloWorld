package co.yedam;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두개의 숫자 입력>>");
		int num1 = Integer.parseInt(scan.next());
		int num2 = Integer.parseInt(scan.next());
		scan.nextLine();
	
		if(num1> num2) {
			System.out.println("큰수 : " + num1);
		}else {
			System.out.println("큰수 : " + num2);
		}
	
	}
}
