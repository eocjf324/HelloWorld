package co.dc.noticeprj.board.service;

import java.util.List;

public interface BoardService {
	List<BoardVO> boardSelectList(); //R
	BoardVO boardSelect(BoardVO vo); //R
	int boardInsert(BoardVO vo);	 //C
	int boardUpdate(BoardVO vo);	 //U	
	int boardDelete(BoardVO vo);	 //D	
}
