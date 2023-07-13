package co.yedam;

import java.util.Scanner;

public class PrintStreamExe3 {
	public static void main(String[] args) {
		//max계산, 평균계산 => 최대값은 00이고 평균은 00입니다.
		// 사용자 3개 숫자(정수) 입력
		
		int max;
		
		Scanner scan = new Scanner(System.in);
		
		/*
		while(true) {
			System.out.print("숫자(정수)입력 :");
			String s1= scan.nextLine();
			int num = Integer.parseInt(s1);
			int temp =0;
			if(num > temp)
				max = num
			
		}
*/
		System.out.print("숫자(정수)입력 :");
		String s1= scan.nextLine();
		System.out.print("숫자(정수)입력 :");
		String s2= scan.nextLine();
		System.out.print("숫자(정수)입력 :");
		String s3= scan.nextLine();
		
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2);
		int n3 = Integer.parseInt(s3);
	

		if(n1 > n2) {
			if(n3 > n1) {max = n3;}
			else { max = n1;}
		}
		else {
			if(n3 > n2) {max = n3;}
			else { max= n2;}
		}
		
		System.out.printf("최대값은 %d이고 평균은 %.1f입니다.", max, (n1+n2+n3)/3.0);
		
		
	}
}
