package co.dc.example.ajax.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet("/AjaxInsertList.do")
public class AjaxInsertList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxInsertList() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TodoService service = new TodoServiceImpl();
		TodoVO vo = new TodoVO();
		//호출 성공 
		vo.setTitle(request.getParameter("title"));
		vo.setDueDate(request.getParameter("dueDate"));
		
		Map<String, Object> map = new HashMap<>();

		if (service.insertList(vo)) {
			map.put("returnCode", "Success");
			map.put("result", vo);
		} else {
			map.put("returnCode", "Fail");
			map.put("result", "등록 중 에러.");
		}

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);

		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
