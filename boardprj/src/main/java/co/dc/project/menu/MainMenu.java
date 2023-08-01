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
	String uid;

	public void run() {
		boolean run = false;
		do {
			uid = "";
			loginMenu();
			int menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1:
				if (login()) {
				
					System.out.println("로그인성공");
					while (!run) {
						boardMenu();
						int boardmenu = Integer.parseInt(scan.nextLine());
						switch (boardmenu) {
						case 1:
							boardList();
							break;
						case 2:
							boardSelect();
							break;
						case 3:
							boardInsert();
							break;
						case 4:
							boardUpdate();
							break;
						case 5:
							boardDelete();
							break;
						case 6:
							run = true;
							break;
						}
					}
					run = false;
					break;
				} else {
					System.out.println("로그인실패");
				}
				break;
			case 2:
				signUp();
				break;
			case 3:
				memberSelect();
				break;
			case 4:
				memberdelete();
				break;
			case 5:
				run = true;
				System.out.println("종료");
				break;
			}
		} while (!run);
	}

	private void loginMenu() {
		System.out.println("===   로그인   ===");
		System.out.println("   1.로그인");
		System.out.println("   2.회원가입");
		System.out.println("   3.회원정보조회");
		System.out.println("   4.회원탈퇴");
		System.out.println("   5.종료");
		System.out.println("================");
		System.out.print("번호선택>>");
	}

	private void boardMenu() {
		System.out.println("===   게시판   ===");
		System.out.println("   1.전체 글 조회");
		System.out.println("   2.글 세부조회");
		System.out.println("   3.글 등록");
		System.out.println("   4.글 수정");
		System.out.println("   5.글 삭제");
		System.out.println("   6.로그아웃");
		System.out.println("================");
		System.out.print("번호선택>>");
	}

	// 유저 메소드
	private boolean login() {
		MemberVO vo = new MemberVO();
		System.out.println("로그인");
		System.out.print("아이디를 입력하세요 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = scan.nextLine();
		vo.setMemberId(id);
		vo.setMemberPassword(pw);
		if (ms.idCheck(id) && ms.passwordCheck(pw)) {
			uid = id;
			return true;
		}
		return false;
	}

	private void signUp() {
		System.out.print("아이디를 입력하세요 : ");
		String id = scan.nextLine();

		if (ms.idCheck(id)) {
			System.out.println("존재하는 계정입니다.");

		} else {
			System.out.print("비밀번호를 입력하세요 : ");
			String pw = scan.nextLine();
			System.out.print("이름을 입력하세요 : ");
			String name = scan.nextLine();
			System.out.print("나이를 입력하세요 : ");
			int age = Integer.parseInt(scan.nextLine());
			System.out.print("성별을 입력하세요(M,F) : ");
			String gender = scan.nextLine();
			System.out.print("전화번호를 입력하세요 : ");
			String tel = scan.nextLine();
			System.out.print("주소를 입력하세요 : ");
			String address = scan.nextLine();
			if (ms.memberInsert(new MemberVO(id, pw, name, age, gender, tel, address)) == 1) {
				System.out.println("계정생성 완료");
			} else {
				System.out.println("계정생성 실패");
			}
		}

	}

	private void memberSelect() {
		MemberVO vo = new MemberVO();
		System.out.print("아이디 입력>>");
		String id = scan.nextLine();
		System.out.print("비밀번호 입력>>");
		String pw = scan.nextLine();
		vo.setMemberId(id);
		vo.setMemberPassword(pw);
		
		if(ms.idCheck(id) && ms.passwordCheck(pw) ){
			System.out.println("아이디\t 이름\t 나이\t 성별\t 전화번호\t\t 멤버주소");
			ms.memberSelect(vo).toString();
		}
		else {
			System.out.println("계정정보가 일치하지 않습니다.");
		}
	}

	private void memberdelete() {
		MemberVO vo = new MemberVO();
		System.out.print("아이디 입력>>");
		String id = scan.nextLine();
		System.out.print("비밀번호 입력>>");
		String pw = scan.nextLine();
		vo.setMemberId(id);
		vo.setMemberPassword(pw);
		if (ms.memberDelete(vo) == 1) {
			uid = id;
			if (bs.boardClear(uid) == 1) {
				System.out.println("계정삭제 완료");
			}
		} else {
			System.out.println("계정삭제 실패");
		}

	}

	/// Board 메소드
	private void boardList() {
		List<BoardVO> boards = bs.boardSelectList();
		if (!boards.isEmpty()) {
			int rows = 5;
			int page = 1;
			int lastpage = (int) Math.ceil(boards.size() / (double) rows);

			while (true) {

				int row = rows * (page - 1);

				if (boards.size() < page * rows) {
					rows = boards.size() % rows;
				}
				System.out.println("글번호\t 작성자\t 제목\t 내용\t\t 작성일자\t\t조회수");
				for (int i = 0; i < rows; i++) {
					boards.get(row).toString();
					row++;
				}
				System.out.printf("\t\t[%d/%d]\n", page, lastpage);
				rows = 5;
				int temp = page;

				System.out.print("페이지입력(0 입력시 게시판 메뉴로 이동)> ");
				page = Integer.parseInt(scan.nextLine());
				if (page > lastpage) {
					System.out.println("페이지를 벗어남");
					page = temp;
				}
				if (page == 0) {
					break;
				}
			}
		} else {
			System.out.println("글이 없습니다.");
		}
	}

	private void boardSelect() {
		BoardVO bo = new BoardVO();
		System.out.print("조회할 글 번호를 입력하세요>> ");
		int boardNum = Integer.parseInt(scan.nextLine());
		bo.setBoardId(boardNum);

		if (bs.boardSelect(bo) != null) {
			System.out.println("글번호\t 작성자\t 제목\t 작성일자\t \t조회수");
			bs.boardHit(bo);
			bs.boardSelect(bo).toString2();
			
		} else {
			System.out.println("등록한 글이 없습니다.");
		}
	}

	private void boardInsert() {
		BoardVO vo = new BoardVO();
		System.out.print("글 제목 입력>>");
		String title = scan.nextLine();
		System.out.print("내용 입력>>");
		String content = scan.nextLine();

		int boardNum = bs.getBoardNum();
		String writer = uid;

		vo.setBoardId(boardNum);
		vo.setBoardWriter(writer);
		vo.setBoardTitle(title);
		vo.setBoardSubject(content);

		if (bs.boardInsert(vo) == 1) {
			System.out.println("글등록 완료");
		} else {
			System.out.println("글등록 실패");
		}
	}

	private void boardUpdate() {
		BoardVO vo = new BoardVO();
		System.out.println("수정할 글번호 입력>>");
		int boardNum = Integer.parseInt(scan.nextLine());
		System.out.println("수정할 내용 입력>>");
		String subject = scan.nextLine();
		String writer = uid;
		vo.setBoardId(boardNum);
		vo.setBoardSubject(subject);
		vo.setBoardWriter(writer);

		if (bs.boardUpdate(vo) == 1) {
			System.out.println("수정완료");
		} else {
			System.out.println("수정실패");
		}
	}

	private void boardDelete() {
		BoardVO vo = new BoardVO();
		System.out.println("삭제할 글번호 입력>>");
		int boardNum = Integer.parseInt(scan.nextLine());
		String writer = uid;
		vo.setBoardId(boardNum);
		vo.setBoardWriter(writer);
		if (bs.boardDelete(vo) == 1) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
	}
}
