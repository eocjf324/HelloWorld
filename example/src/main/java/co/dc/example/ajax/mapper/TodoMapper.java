package co.dc.example.ajax.mapper;

import java.util.List;

import co.dc.example.ajax.service.MembersVO;
import co.dc.example.ajax.service.TodoVO;

public interface TodoMapper {
	public List<TodoVO> todoList();
	public int insertList(TodoVO vo);
	public int deleteList(TodoVO vo);
	public int updateList(TodoVO vo);
}
