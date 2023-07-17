package co.yedam.reference;

import java.util.Scanner;

public class ArrayPracticeExe {
	static int[] scores = null; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice6();

	}

	public static void practice6() {

		boolean run = true;
		int studentNum =0; //학생수
		
		int sum = 0;
		int max = 0;
		Scanner scan = new Scanner(System.in);
		
		while (run) {
			System.out.println("------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("------------------");
			System.out.print("선택>");
			int selectNo = Integer.parseInt(scan.nextLine());
			
			switch(selectNo) {
			case 1:
				System.out.print("학생수>");
				studentNum = Integer.parseInt(scan.nextLine());
				scores = new int[studentNum]; //학생수만큼 배열선언
				break;
			case 2:
				if(nullCheck() == 1) {
					continue;
				}
				for(int i = 0 ; i < scores.length; i++) {
					System.out.printf("scores[%d]>", i); // scores[i]  >   입력 
					scores[i] =Integer.parseInt(scan.nextLine());
					
				}
				break;
			case 3:
				if(nullCheck() == 1) {
					continue;
				}
				for(int i =0; i< scores.length; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
					sum += scores[i];
					if(max < scores[i]) {
						max = scores[i];
					}
				}
				break;
			case 4:
				if(nullCheck() == 1) {
					continue;
				}
				System.out.printf("최고 점수: %d\n", max);
				System.out.printf("평균 점수: %.1f\n", (double) sum / scores.length );
				break;
			case 5:
				run = false;
				
			}
			System.out.println("종료");
		}
	}
	public static int nullCheck() {
		if(scores == null) {
			System.out.println("배열에 값이 없습니다.");
			return 1;
		}
		else
			return 0;
	}
}
