package co.dc.test.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dc.test.book.mapper.BookMapper;
import co.dc.test.book.service.BookService;
import co.dc.test.book.service.BookVO;
import co.dc.test.common.DataSources;

public class BookServiceImpl implements BookService {

	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private BookMapper map = sqlSession.getMapper(BookMapper.class);
	@Override
	public List<BookVO> bookList() {
		
		return map.bookList();
	}

	@Override
	public boolean insertBook(BookVO vo) {
	
		return map.insertBook(vo) == 1;
	}

	@Override
	public boolean deleteBook(BookVO vo) {
		
		return map.deleteBook(vo) == 1;
	}

}
