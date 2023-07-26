package co.yedam.boardpkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Menu {
	int ADD = 1, EDIT = 2, DEL = 3, LIST = 4, INFO = 5, EXIT = 6;
}

public class MainExe {
	public static void menuPrint() {
		System.out.println("1.등록 2.수정 3.삭제 4.목록 5.개인정보 6.종료");
		System.out.print("선택>> ");
	}

	public static void main(String[] args) {
	
		BoardService svc = new BoardApp(); // 파일에 읽고 쓸지
//		BoardService svc = new BoardDAO(); // 오라클에 읽고 쓸지 
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		String uid = "";
		String upw = "";
		String uname ="";
		while(run) {
			System.out.print("아이디입력>");
			String id = scan.nextLine();
			System.out.print("비밀번호입력>");
			String pw = scan.nextLine();
			if(svc.login(id, pw)) {
				System.out.println("로그인성공");
				uid = id;
				upw = pw;
				run = false;
			}
			else {
				System.out.println("로그인실패");
			}
		}
		run = true;
		while (run) {
		
			menuPrint();
			int menu = Integer.parseInt(scan.nextLine());

			switch (menu) {
			case Menu.ADD:
				System.out.println("글등록");
				
				System.out.print("글번호");
				int no = Integer.parseInt(scan.nextLine());
				System.out.print("글제목");
				String title = scan.nextLine();
				System.out.print("내용");
				String content = scan.nextLine();
				String writer = uid;
				System.out.print("등록날짜");
				String writeDate = scan.nextLine();
				
				if(svc.addBoard(new Board(no,title,content,writer,writeDate))) {
					System.out.println("등록 성공");
				}else{
					System.out.println("등록 실패");
				};
				break;
			case Menu.EDIT:
				System.out.print("수정할 글번호");
				no = Integer.parseInt(scan.nextLine());
				System.out.print("수정할 내용");
				content = scan.nextLine();
				if(svc.editBoard(new Board(no, content))) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				};
				break;
			case Menu.DEL:
				System.out.print("삭제할 글번호");
				no = Integer.parseInt(scan.nextLine());
				if(svc.delBoard(no)) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				};	
				break;
			case Menu.LIST:
				for (Board brd : svc.boardList()) {
					System.out.println(brd.toString());
				}
				break;
			case Menu.INFO:
				String id = uid;
				
				System.out.print("변경할 비밀번호입력>");
				String pw = scan.nextLine();
				
				System.out.print("변경할 이름입력>");
				String name = scan.nextLine();
				if(pw.isEmpty()) {
					pw = upw;
				}
				if(name.isEmpty()) {
					for(int i =0; i< svc.boardList().size(); i++) {
						name = svc.boardList().get(i).getWriter();
					}
	
//					for(int i=0; i<  svc.userList().size(); i++) {
//						name = svc.userList().get(i).getUserName();
//					}
				}	
				
			
				if(svc.modInfo(new User(id,name ,pw))){
					System.out.println("개인정보 수정 성공");
				}else {
					System.out.println("개인정보 수정 실패");
				}
				
				break;
			case Menu.EXIT:
				svc.exit();
				System.out.println("종료");
				run = false;
			}
		}
		System.out.println("end of prog.");
		scan.close();
	}
}
