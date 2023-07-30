package co.dc.project.menu;

import java.util.List;
import java.util.Scanner;

import co.dc.project.boardprj.board.service.BoardService;
import co.dc.project.boardprj.board.service.BoardVO;
import co.dc.project.boardprj.board.serviceImpl.BoardServiceImpl;
import co.dc.project.boardprj.member.Service.MemberService;
import co.dc.project.boardprj.member.Service.MemberVO;
import co.dc.project.boardprj.member.ServiceImpl.MemberServiceImpl;

public class MainMenu {

	Scanner scan = new Scanner(System.in);
	private MemberService ms = new MemberServiceImpl();
	private BoardService bs = new BoardServiceImpl();

	public void run() {
		boolean run = false;
		do {
			loginMenu();
			int menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				if(login()) {
					System.out.println("로그인성공");
					boardMenu();
					int boardmenu = Integer.parseInt(scan.nextLine());
					switch(boardmenu) {
					case 1:
						boardList();
						break;
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					}
				}else {
					System.out.println("로그인실패");
				}
				break;
			case 2:
				break;
			case 3:
				//searchId();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				run = true;
				System.out.println("종료");
				break;
			}
		} while (!run);
	}

	private void boardList() {
		List<BoardVO> boards = bs.boardSelectList();
		if (!boards.isEmpty()) {
			for (BoardVO board : boards) {
				board.toString();
			}
		}
		else {
			System.out.println("회원이 한명도 존재하지 않습니다.");	
		}
		
	}

	private void loginMenu() {
		System.out.println("===   게시판   ===");
		System.out.println("   1.로그인");
		System.out.println("   2.회원가입");
		System.out.println("   3.아이디찾기");
		System.out.println("   4.비밀번호찾기");
		System.out.println("   5.개인정보 조회/수정");
		System.out.println("   6.회원탈퇴");
		System.out.println("   7.종료");
		System.out.println("================");
		System.out.print("번호선택>>");
	}
	private void boardMenu() {
		System.out.println("===   게시판   ===");
		System.out.println("   1.글 조회");
		System.out.println("   2.글 세부조회");
		System.out.println("   3.글 등록");
		System.out.println("   4.글 수정");
		System.out.println("   5.글 삭제");
		System.out.println("   6.게시판 종료");
		System.out.println("================");
		System.out.print("번호선택>>");
	}

	
	// 유저 메소드
	private boolean login() {
		MemberVO member = new MemberVO();
		System.out.println("로그인");
		System.out.print("아이디를 입력하세요 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = scan.nextLine();

		member.setMemberId(id);
		member.setMemberPassword(pw);
		if(ms.memberCheck(id, pw) ) {
			return true;
		}
		return false;
	}

//	private void searchId() {
//		MemberVO member = new MemberVO();
//		System.out.println("===찾을 회원의 전화번호를 입력하세요.===");
//		String tel = scan.nextLine();
//		member.setMemberTel(tel);
//		member = ms.searchId(member);
//		if (member.getMemberId() != null) {
//			System.out.println("회원의 아이디는 : " + member.getMemberId());
//		} else {
//			System.out.println("존재하지 않는 회원입니다. ㅜㅜ");
//		}
//	}
}
