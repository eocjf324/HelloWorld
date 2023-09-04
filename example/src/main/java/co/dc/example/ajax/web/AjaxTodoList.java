package co.dc.example.ajax.
web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dc.example.ajax.service.TodoService;
import co.dc.example.ajax.service.TodoVO;
import co.dc.example.ajax.serviceImpl.TodoServiceImpl;

@WebServlet("/AjaxTodoList.do")
public class AjaxTodoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AjaxTodoList() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TodoService service = new TodoServiceImpl();
		List<TodoVO> list = service.todoList();
	
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
