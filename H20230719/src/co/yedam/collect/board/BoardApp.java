package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;

public class BoardApp {
	//게시글저장.
	List<Board> boards = new ArrayList<>();
	
	//등록
	boolean addBoard(Board board) {
		
		for(int i=0 ;i < boards.size() ; i++) {
			if(boards.get(i).getBoardNo() == board.getBoardNo()) {
				System.out.println("실패");
				return false;
			}
		}
		boards.add(board);
//		System.out.println("출력 " + boards);
		return true;
	}
	//목록
	List<Board> boardList(){
		return boards;
	}
	//조회
	Board getBoard(int boardNo) {
		
		for(int i=0 ;i < boards.size() ; i++) {
			if(boards.get(i).getBoardNo() == boardNo) {
				return boards.get(i);
			}
		}
		return null; //없으면
	}
	
	//삭제
	boolean delBoard(int boardNo) {
		
		for(int i=0 ;i < boards.size() ; i++) {
			if(boards.get(i).getBoardNo() == boardNo) {
				
				boards.remove(i);
				return true;
			}
		}
		
		return false;
	}
}
