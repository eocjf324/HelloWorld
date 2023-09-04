package co.dc.example.ajax.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dc.example.ajax.mapper.TodoMapper;
import co.dc.example.ajax.service.TodoService;
import co.dc.example.ajax.service.TodoVO;
import co.dc.example.common.DataSources;

public class TodoServiceImpl implements TodoService {

	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private TodoMapper map = sqlSession.getMapper(TodoMapper.class);
	@Override
	public List<TodoVO> todoList() {
		
		return map.todoList();
	}

	@Override
	public boolean insertList(TodoVO vo) {
		
		return map.insertList(vo) == 1;
	}

	@Override
	public boolean deleteList(TodoVO vo) {
		
		return map.deleteList(vo) == 1;
	}

	@Override
	public boolean updateList(TodoVO vo) {
	
		return map.updateList(vo) == 1;
	}

}
