package co.dc.test.book.mapper;

import java.util.List;

import co.dc.test.book.service.BookVO;

public interface BookMapper {
	public List<BookVO> bookList();
	public int insertBook(BookVO vo);
	public int deleteBook(BookVO vo);
}
