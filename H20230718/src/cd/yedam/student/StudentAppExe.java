package cd.yedam.student;

import java.util.Scanner;

public class StudentAppExe {
	static Scanner scan = new Scanner(System.in);
	static StudentApp app = new StudentApp();

	public static void main(String[] args) {

		init(); // 초기값 설정
		app(); // 실행

	}

	public static void init() {
		//app.addStudent(new Student("001", "홍길동", 80, 177.7));
		app.addStudent(new Student("002", "김길동", 85, 178.7));
	}

	public static void app() {
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.합계 4.최고점 5.종료.");
			System.out.print("번호입력>");
			int menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				register();
			} else if (menu == 2) {
				Student[] ary = app.studentList();
				for (int i = 0; i < ary.length; i++) {
					if (ary[i] != null) {
						System.out.printf("학생번호 %s, 이름 %s, 점수 %d, 키 %.1f\n", ary[i].stdNo, ary[i].stdName, ary[i].score,
								ary[i].height);
					}
				}
			} else if (menu == 3) {
				int sum = app.sumScore();
				System.out.println("점수의 합계: " + sum);
			} else if (menu == 4) {
				int max =app.maxPrint();
				System.out.println("최고점수: " + max);
			} else if (menu == 5) {
				run = false;
				System.out.println("종료");
			}
		}
	}

	
	public static void register() {
		System.out.print("번호입력>");
		String num = scan.nextLine();
		System.out.print("이름입력>");
		String name = scan.nextLine();
		System.out.print("점수입력>");
		int score = Integer.parseInt(scan.nextLine());
		System.out.print("키입력>");
		double height = Double.parseDouble(scan.nextLine());

		Student student = new Student(num, name, score, height);
		if (app.addStudent(student)) {
			System.out.println("정상적으로 등록되었습니다.");
		} else {
			System.out.println("등록x");
		}
	}
}
