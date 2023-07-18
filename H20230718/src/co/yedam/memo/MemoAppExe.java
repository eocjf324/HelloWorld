package co.yedam.memo;

import java.util.Scanner;

import cd.yedam.student.Student;

public class MemoAppExe {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean run = true;
		MemoApp app = new MemoApp();
		while (run) {

			System.out.println("1.메모등록 2.메모수정 3.메모삭제 4.메모록록 5.메모조회 6.종료");
			System.out.print("번호입력>");

			int choose = Integer.parseInt(scan.nextLine());

			if (choose == 1) {
				System.out.print("번호 내용 날짜 입력>>> ");
				String num = scan.next();
				String content = scan.next();
				String date = scan.next();
				scan.nextLine();
				Memo memo = new Memo(num, content, date);
				// app.addMemo(memo);

				if (app.addMemo(memo)) {
					System.out.println("정상적으로 등록되었습니다.");
				} else {
					System.out.println("등록x");
				}

			} else if (choose == 2) {

//				boolean check =true;
//				System.out.println("메모수정");
//				System.out.print("번호입력>>");
//				String num = scan.nextLine();
//				
//				for (int i = 0; i < app.memos.length; i++) {
//					if (app.memos[i] != null && app.memos[i].memoNum.equals(num)) {
//						System.out.print("수정할 메모 입력>> ");
//						String str = scan.nextLine();
//						app.memos[i].setContent(num2);;						
//						System.out.println("수정되었습니다.");
//						check = false;
//					}
//				}
//				if (check == true) {
//					System.out.println("회원번호가 없습니다.");
//				}
				//// 클래스 매개변수 활용
				System.out.println("메모수정");
				System.out.print("번호입력>>");
				String num = scan.nextLine();
				System.out.print("수정할 메모 입력>> ");
				String str = scan.nextLine();

				if (app.editMemo(num, str)) {
					System.out.println("수정되었습니다.");
				} else {
					System.out.println("회원번호가 없습니다.");
				}

			} else if (choose == 3) {

				System.out.println("메모삭제");
				System.out.print("번호입력>>");
				String str = scan.nextLine();

				if (app.delMemo(str)) {
					System.out.println("수정되었습니다.");
				} else {
					System.out.println("회원번호가 없습니다.");
				}
			} else if (choose == 4) {
				System.out.println("메모목록");
				Memo[] ary = app.MemoList();
				for (int i = 0; i < ary.length; i++) {
					if (ary[i] != null) {
						System.out.printf("메모번호: %s, 내용: %s, 날짜 %s\n", ary[i].memoNum, ary[i].content, ary[i].date);
					}
				}
			} else if (choose == 5) {
				System.out.println("메모조회");
				System.out.print("번호입력>>");
				String str = scan.nextLine();
//				if (app.findMemo(str) =) {
//					System.out.printf("번호 : %s, 내용 : %s", );
//				} else {
//					System.out.println("회원번호가 없습니다.");
//				}
				String result = app.findMemo(str);
				if(result == null) {
					System.out.println("회원번호가 없습니다.");
				}else {
					System.out.printf("회원번호: %s, 메모내용: %s\n", str, result);
				}
			} else if (choose == 6) {
				run = false;
				System.out.println("종료");
			}

		}

	}
}
