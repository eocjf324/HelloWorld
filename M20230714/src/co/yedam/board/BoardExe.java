package co.yedam.board;

import java.util.Scanner;

public class BoardExe {
	static Scanner scan = new Scanner(System.in);
	static Board[] boards = new Board[20];
	static int menu = 0;

	private static void init() {
		boards[0] = new Board(1,"가","aaaaaaaaaaaaa","김");
		boards[1] = new Board(2,"나","bbbbbbbbbbbbb","나");
		boards[2] = new Board(3,"다","cccccccccccc","박");
		boards[3] = new Board(4,"라","dddddddddddd","이");
		boards[4] = new Board(5,"마","eeeeeeeeeee","신");
		boards[5] = new Board(6,"바","ffffffffff","박");
		boards[6] = new Board(7,"사","gggggggggggg","류");
		boards[7] = new Board(8,"아","gghhhhhhhhhh","조");
		boards[8] = new Board(9,"자","gghhhhhddzh","서");
		boards[9] = new Board(10,"차","gghhhhh","최");
		
	}

	private static void addBoard() { // 등록기능
		Board board = new Board();
		

		System.out.println("글등록");

		System.out.print("글번호>");
		int bno = Integer.parseInt(scan.nextLine());
		System.out.print("글제목>");
		String bname = scan.nextLine();
		System.out.print("글내용>");
		String content = scan.nextLine();
		System.out.print("작성자>");
		String writter = scan.nextLine();

		board.setBoardNum(bno);
		board.setBoardName(bname);
		board.setContent(content);
		board.setWritter(writter);

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				break;
			}
		}
	}

	private static void list() {
	
//		System.out.println(cnt);
//		for (int i = 0; i < boards.length; i++) {
//			int cnt =0;
//			if (boards[i] != null) {
//				
//				System.out.println(boards[i].showInfo());
//			}
//		}
		int cnt =1;
		while(true) {
			
			for(int i=0; i< 5; i++) {
				System.out.println(boards[i +((cnt-1) * 5)].showInfo());
			}
			System.out.printf("현재페이지/총페이지 %d/%d\n", cnt,boards.length /5);
			System.out.print("이동할 페이지 선택>");
			int n= Integer.parseInt(scan.nextLine());
			cnt = n;
//			int cnt =0;
//			for(int i=0; i< boards.length ;i++) {
//				if(boards[i] != null) {
//					cnt++;
//				}
//				
//			}
		
		}
		
		
		
		
		
	}
	private static void modify() {
		Board board = new Board();
		boolean check = true;
		System.out.println("수정");
		System.out.print("글번호 입력>");
		int num = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNum() == num) {
				System.out.print("수정할 내용 입력>");
				String modify = scan.nextLine();
				board.setContent(modify);
				check = false;
				break;
			}
		}
		if (check == true) {
			System.out.println("없는 글입니다.");
		}

	}
	private static void delete() {
		boolean check = true;
		System.out.println("삭제");
		System.out.print("글번호 입력>");
		int num = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNum() == num) {
				boards[i] = null;
				check = false;
				break;
			}
		}
		if (check == true) {
			System.out.println("없는 글입니다.");
		}

	}
	private static void showDetail() {
		
		boolean check = true;
		System.out.println("상세보기");
		System.out.print("글번호 입력>");
		int num = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNum() == num) {
				System.out.println(boards[i].showDetail());
				check = false;
				break;
			}
		}
		if (check == true) {
			System.out.println("없는 글입니다.");
		}

	}

	public static void main(String[] args) {

		init(); // 실행

		boolean run = true;
		while (run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세보기 6.종료");
			System.out.print("번호입력> ");
			menu = Integer.parseInt(scan.nextLine());
			if (menu == 1) {
				addBoard();
			} else if (menu == 2) {
				list();
			} else if (menu == 3) {
				modify();
			} else if (menu == 4) {
				delete();
			} else if (menu == 5) {
				showDetail();
			} else if (menu == 6) {
				run = false;
				System.out.println("종료");
			}
		}
	}
}
