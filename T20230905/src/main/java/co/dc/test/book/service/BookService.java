package co.dc.test.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> bookList();
	public boolean insertBook(BookVO vo);
	public boolean deleteBook(BookVO vo);
	
}
