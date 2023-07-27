package co.yedam.board;

import java.io.IOException;
import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		BoardApp ba = new BoardApp();
		boolean run = true;
		
		System.out.println("게시판");
		while (run) {
			System.out.println("1.추가 2.수정 3.조회 4.삭제 5.목록조회 6.종료");
			System.out.print("번호입력> ");
			int menu = Integer.parseInt(scan.nextLine());
			if (menu == 1) {
				System.out.println("등록");
				int bno = ba.getNo();
				System.out.print("제목>");
				String title = scan.nextLine();
				System.out.print("내용>");
				String content = scan.nextLine();
				System.out.print("작성자>");
				String writer = scan.nextLine();
				System.out.print("작성일자>");
				String date = scan.nextLine();
		
				if(ba.register(new Board(bno,title,content,writer,date))) {
					System.out.println("등록성공");
				}else {
					System.out.println("등록실패");		
				}
			} else if (menu == 2) {
				System.out.print("수정할 번호입력>");
				int bno = Integer.parseInt(scan.nextLine());
				System.out.print("수정할 내용>");
				String content = scan.nextLine();
				if(ba.modify(new Board(bno, content))) {
					System.out.println("수정성공");
				}else {
					System.out.println("수정실패");
				}
			} else if (menu == 3) {
				System.out.print("조회할 번호입력>");
				int bno = Integer.parseInt(scan.nextLine());
				
				if(ba.search(bno) ==null) {
					System.out.println("조회 실패");
				}else {
					System.out.println(ba.search(bno));
				}
			} else if (menu == 4) {
				System.out.print("삭제할 번호입력>");
				int bno = Integer.parseInt(scan.nextLine());
				if(ba.remove(bno)) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
			} else if (menu == 5) {
				for (Board board : ba.list()) {
					System.out.println(board.toString());
				}
			}
			else if (menu == 6) {
				ba.writeToFile();
				System.out.println("종료");
				run = false;
			}
		}
	}

}
