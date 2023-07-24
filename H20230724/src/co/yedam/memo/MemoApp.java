package co.yedam.memo;

import java.util.Scanner;
//2023-07-24 복습하기(프로그램 실행시 파일 불러오기, 종료시 저장하는 코드, 기본키 설정 코드 , 날짜 오늘날짜로 셋 
public class MemoApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemoManager manager = new MemoManager();
		int menu = 0;
		
		double num1 = 7;
		double num2 = 3;
		System.out.println((int)(num1/ num2 * 1000));
		boolean run = true;
		while (run) {
			manager.printMenu();
			menu = Integer.parseInt(scan.nextLine());
			if (menu == 1) {
				manager.inputData();
			} else if (menu == 2) {
				manager.searchData();
			} else if (menu == 3) {
				manager.deleteData();
			} else if (menu == 4) {
				manager.memoList();
			} else if (menu == 5) {
				manager.stroeTofile();
				run = false;
			}
		}
	}		
}
