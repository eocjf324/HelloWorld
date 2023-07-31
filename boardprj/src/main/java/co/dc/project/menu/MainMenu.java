package co.dc.project.menu;

import java.time.LocalDate;
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
				if (signUp()) {
					System.out.println("회원가입완료");
				} else {
					System.out.println("회원가입실패");
				}
				break;
			case 3:
				if (memberdelete()) {
					if (bs.boardClear(uid) == 1) {
						System.out.println("계정삭제");
					}
				} else {
					System.out.println("계정삭제실패");
				}
				break;

			case 4:
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
		System.out.println("   3.회원탈퇴");
		System.out.println("   4.종료");
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

		if (ms.memberCheck(id, pw)) {
			uid = id;
			return true;
		}

		return false;

	}

	private boolean signUp() {
		System.out.print("아이디를 입력하세요 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = scan.nextLine();
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine();
		System.out.print("나이를 입력하세요 : ");
		int age = Integer.parseInt(scan.nextLine());
		System.out.print("성별을 입력하세요 : ");
		String gender = scan.nextLine();
		System.out.print("전화번호를 입력하세요 : ");
		String tel = scan.nextLine();
		System.out.print("주소를 입력하세요 : ");
		String address = scan.nextLine();
		if (ms.memberInsert(new MemberVO(id, pw, name, age, gender, tel, address)) > 0) {
			return true;
		} else {
			return false;
		}

	}

	private boolean memberdelete() {
		MemberVO vo = new MemberVO();
		System.out.print("아이디 입력>>");
		String id = scan.nextLine();
		System.out.print("비밀번호 입력>>");
		String pw = scan.nextLine();
		vo.setMemberId(id);
		vo.setMemberPassword(pw);
		if (ms.memberDelete(vo) == 1) {
			uid = id;
			return true;
		}
		return false;
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
				for (int i = 0; i < rows; i++) {
					boards.get(row).toString();
					row++;
				}
				rows = 5;
				System.out.printf("[%d/%d]\n", page, lastpage);
				System.out.print("페이지입력(0 입력시 게시판 메뉴로 이동)> ");
				page = Integer.parseInt(scan.nextLine());
				if (page > lastpage) {
					System.out.println("페이지를 벗어남");
					page = 1;
				}
				if (page == 0) {
					break;
				}
			}
		} else {
			System.out.println("회원이 한명도 존재하지 않습니다.");
		}

	}

	private void boardSelect() {
		BoardVO board = new BoardVO();
		System.out.println("조회할 글 번호를 입력하세요");
		int boardNum = Integer.parseInt(scan.nextLine());
		board.setBoardId(boardNum);
		BoardVO bo = bs.boardSelect(board);

		if (bo.getBoardTitle() != null) {
			board.toString();
			bs.boardHit(board);
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

		LocalDate date = LocalDate.now();
		vo.setBoardId(boardNum);
		vo.setBoardWriter(writer);
		vo.setBoardTitle(title);
		vo.setBoardSubject(content);
		vo.setBoardDate(date);
		vo.setBoardHit(0);

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
