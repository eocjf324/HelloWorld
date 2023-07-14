package co.yedam.reference;

import java.util.Scanner;

public class StrArrayExe {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] strAry = new String[3]; // 크기가 3인 배열.
		int[] scores = new int[3];
		
		for (int i = 0; i < strAry.length; i++) {
			System.out.print("이름>> ");
			strAry[i] = scan.nextLine();
			System.out.print("점수>> ");
			scores[i]= Integer.parseInt(scan.nextLine());
		}
		
//		System.out.print("검색하고 싶은 학생의 이름을 입력>>> ");
//		String searchName = scan.nextLine();
		
		//최고점수를 구하고. 학생의 이름출력 
		int maxScore = 0;
		String maxName = "";
	
	
		for(int i =0; i< scores.length; i++) {
			if(maxScore < scores[i]) {
				maxScore = scores[i];
				maxName = strAry[i];
			}
		}
		;
		System.out.printf("이름은 %s, 점수는 %d \n", maxName, maxScore);
		
//		for(int i = 0; i<strAry.length; i++) {
//		if(strAry[i].equals(searchName)) {
//		System.out.printf("이름은 %s, 점수는 %d \n", strAry[i], scores[i]);
//		}
//	}
	}
}
