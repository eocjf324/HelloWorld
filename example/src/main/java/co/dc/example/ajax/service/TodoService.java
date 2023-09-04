package co.dc.example.ajax.service;

import java.util.List;

public interface TodoService {
	public List<TodoVO> todoList();
	public boolean insertList(TodoVO vo);
	public boolean deleteList(TodoVO vo);
	public boolean updateList(TodoVO vo);
	
}
