package co.yedam.grade;

import java.util.Scanner;

import co.yedam.product.ProductManage;

public class StudentMangeApp {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StudentManage sm = new StudentManage();
		
		boolean run = true;
		System.out.println("성적관리프로그램");
		while (run) {
			System.out.println("1.학생정보입력 2.성적입력 3.전체성적출력 4.장학금대상자 5.종료");
			System.out.print("번호 입력>");
			int menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				sm.insertStudent();
			} else if (menu == 2) {
				sm.insertScore();
			} else if (menu == 3) {
				sm.StudentList();
			} else if (menu == 4) {
				sm.StudentA();
			} else if (menu == 5) {
				sm.storeTofile();
				run = false;
			}

		}
	}

}
