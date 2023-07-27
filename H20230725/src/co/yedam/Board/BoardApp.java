package co.yedam.Board;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		BoardManage bm = new BoardManage();
		boolean run = true;
		
		bm.login();  //로그인 
		
		while (run) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.목록 5.종료");
			System.out.print("번호 입력>");
			int menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				bm.addBoard();
			} else if (menu == 2) {
				bm.editBoard();
			} else if (menu == 3) {
				bm.delBoard();
			} else if (menu == 4) {
				bm.list();
			} else if (menu == 5) {
				System.out.println("종료");
				bm.storeToUser();
				bm.storeToBoard();
				run = false;
			}else if (menu == 9) {
				
			}

		}
	}
}
