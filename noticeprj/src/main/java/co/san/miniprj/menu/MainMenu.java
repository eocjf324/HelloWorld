package co.san.miniprj.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.dc.noticeprj.board.service.BoardService;
import co.dc.noticeprj.board.service.BoardVO;
import co.dc.noticeprj.board.serviceImpl.BoardServiceImpl;
import co.san.miniprj.member.service.MemberService;
import co.san.miniprj.member.service.MemberVO;
import co.san.miniprj.member.serviceImpi.MemberServiceImpl;

public class MainMenu {

	private Scanner scan = new Scanner(System.in);
	private MemberService ms = new MemberServiceImpl(); // DAO

	private void mainTitle() {
		System.out.println("==== 학사관리 ====");
		System.out.println("==1.회원 관리   ==");
		System.out.println("==2.공지사항 관리==");
		System.out.println("==3.학사관리 종료==");
		System.out.println("================");
		System.out.println("학사관리 메뉴 선택>> ");
	}

	private void memberTitle() {
		System.out.println("==== 회원관리 ====");
		System.out.println("==1.전체회원 조회==");
		System.out.println("==2.회원한명 조회==");
		System.out.println("==3.회원정보 등록==");
		System.out.println("==4.회원정보 수정==");
		System.out.println("==5.회원정보 삭제==");
		System.out.println("==6.회원관리 종료==");
		System.out.println("==7.게시글 보기 ==");
		System.out.println("================");
		System.out.println("회원관리 메뉴선택>> ");
	}

	private void boardTitle() {
		System.out.println("==== 공지관리 ====");
		System.out.println("==1.공지사항 조회==");
		System.out.println("==2.공지사항 세부==");
		System.out.println("==3.공지사항 등록==");
		System.out.println("==4.공지사항 수정==");
		System.out.println("==5.공지사항 삭제==");
		System.out.println("==6.공지사항 종료==");
		System.out.println("==7.게시글 보기 ==");
		System.out.println("================");
		System.out.println("공지관리 메뉴선택>> ");
	}

	// 여기서 CRUD 메소드를 private로 하나씩 만들어 간다.

	private void memberSelect() {
		MemberVO member = new MemberVO();
		System.out.println("===검색할 회원의 아이디를 입력하세요?.===");
		scan.nextLine();
		String id = scan.nextLine();
		member.setMemberId(id);
		member = ms.memberSelect(member);

		if (member.getMemberName() != null) {
			member.toString();
		} else {
			System.out.println("존재하지 않는 회원입니다. ㅜㅜ");
		}

	}

	private void memberInsert() {

	}

	public void run() {
		boolean b = false;
		do {
			mainTitle();
			int mainKey = scan.nextInt();

			if (mainKey == 1) {
				memberTitle();

				int key = scan.nextInt();
				switch (key) {
				case 1:
				//	membersSelectList();
					break;
				case 2:
					memberSelect();
					break;
				case 3:
					memberInsert();
					break;
				case 4:
				case 5:
				case 6:
					System.out.println("작업을 종료합니다.!!");
					break;
				}
			} else if (mainKey == 2) {
				boardTitle();
				break;
			} else if (mainKey == 3) {
				System.out.println("프로그램 종료 종료");
				b = true;
				break;
			}
		} while (!b);

		scan.close();
	}

	private void boardList() {
		BoardService bs = new BoardServiceImpl();
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = bs.boardSelectList();

		for (BoardVO board : boards) {
			board.toString();
		}

	}

}
