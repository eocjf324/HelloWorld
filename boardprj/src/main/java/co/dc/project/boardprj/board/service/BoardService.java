package co.dc.project.boardprj.board.service;

import java.util.List;

public interface BoardService {
	List<BoardVO> boardSelectList();  //글 전체조회
	BoardVO boardSelect(BoardVO vo);  //세부 조회
	int boardInsert(BoardVO vo);	  //글 작성
	int boardUpdate(BoardVO vo);	  //글 수정 (내용만 수정)
	int boardDelete(BoardVO vo);	  //글 삭제 (작성자랑 로그인 아이디가 같은거)
}
