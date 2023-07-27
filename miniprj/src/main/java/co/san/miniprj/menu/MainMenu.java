package co.san.miniprj.menu;

import java.util.List;
import java.util.Scanner;

import co.san.miniprj.member.service.MemberService;
import co.san.miniprj.member.service.MemberVO;
import co.san.miniprj.member.serviceImpi.MemberServiceImpl;

public class MainMenu {

	private Scanner scan = new Scanner(System.in);
	private MemberService ms = new MemberServiceImpl(); // DAO

	private void mainTitle() {
		System.out.println("==== 회원관리 ====");
		System.out.println("==1.전체회원 조회==");
		System.out.println("==2.회원한명 조회==");
		System.out.println("==3.회원정보 등록==");
		System.out.println("==4.회원정보 수정==");
		System.out.println("==5.회원정보 삭제==");
		System.out.println("==6.회원관리 종료==");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요? ");
	}

	// 여기서 CRUD 메소드를 private로 하나씩 만들어 간다.
	private void membersSelectList() {
		List<MemberVO> members = ms.memberSelectList();
		if (!members.isEmpty()) {
			for (MemberVO member : members) {
				member.toString();
			}
		}
		else {
			System.out.println("회원이 한명도 존재하지 않습니다.");	
		}
	}

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
			int key = scan.nextInt();
			switch (key) {
			case 1:
				membersSelectList();
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
				b = true;
				break;
			}

		} while (!b);

		scan.close();
	}


}
