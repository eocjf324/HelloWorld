package co.yedam;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int sum1 =0; 
		int sum2 =0;
		int max, min;
		System.out.print("두 정수값 입력>>");
		int num1 = Integer.parseInt(scan.next());
		int num2 = Integer.parseInt(scan.next());
		scan.nextLine();
		
		if(num1 > num2) {
			max = num1;
			min = num2;
		}
		else {
			max= num2;
			min= num1;
		}
	
		for(int i = min ; i<= max; i++) {
			if(i % 2 ==0) {
				sum1 += i;
			}
			if(i % 3 ==0) {
				sum2 += i;
			}
		}
		System.out.printf("2의 배수의 합 : %d\n3의 배수의 합 : %d",sum1,sum2);
	}

}
