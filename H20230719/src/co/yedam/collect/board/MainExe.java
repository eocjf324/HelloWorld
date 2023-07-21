package co.yedam.collect.board;

import java.util.List;
import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 로그인 아이디 입력 , 비빌번호 입력
		// 1.등록 2.목록 3.단건조회 4.삭제. 9.종료
		Scanner scan = new Scanner(System.in);
		String logId = "";
		UserApp uApp = new UserApp();
		BoardApp bApp = new BoardApp();
		boolean run = true;
		int menu = 0;
		while (run) {
			System.out.println("아이디와 비밀번호를 입력(ex)>>>");
			System.out.print("아이디>> ");
			String id = scan.nextLine();
			System.out.print("비번>> ");
			String pwd = scan.nextLine();

			if (uApp.login(id, pwd)) {
				System.out.println("로그인되었습니다.");
				logId = id;
				run = false;
			} else
				System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		// 로그인 완료
		// 메뉴
		run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.삭제. 9.종료");
			System.out.print("번호입력>");
			menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				System.out.println("등록");
				System.out.print("번호 입력>");
				int boardNo = Integer.parseInt(scan.nextLine());
				System.out.print("제목 입력>");
				String title = scan.nextLine();
				System.out.print("내용 입력>");
				String content = scan.nextLine();
				String writer = logId;

				if (bApp.addBoard(new Board(boardNo, title, content, writer))) {
					System.out.println("등록되었습니다.");
				} else {
					System.out.println("등록되지 않았습니다.(존재하는 게시판 번호입니다.");
				}

			} else if (menu == 2) {
				System.out.println("조회");
				// System.out.println(bApp.boardList());

				List<Board> li = bApp.boardList();
				for (Board b : li) {
					System.out.println(b.toString());
				}

			} else if (menu == 3) {
				System.out.println("단건조회");
				System.out.print("번호 입력>");
				int boardNo = Integer.parseInt(scan.nextLine());

				if (bApp.getBoard(boardNo) == null) {
					System.out.println("존재하지않는 게시판번호입니다.");
				} else {
					System.out.println(bApp.getBoard(boardNo).toString());
				}

			} else if (menu == 4) {
				System.out.println("삭제"); // 본인 글만 지움
				System.out.print("번호 입력>");
				int boardNo = Integer.parseInt(scan.nextLine());
				
				
				if (bApp.delBoard(boardNo)) {
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("삭제되지 않았습니다.");
					
				}
			} else if (menu == 9) {
				System.out.println("종료");
				run = false;
			}
		}

	}

}
