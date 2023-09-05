package co.dc.test.book.web;

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

import co.dc.test.book.service.BookService;
import co.dc.test.book.service.BookVO;
import co.dc.test.book.serviceImpl.BookServiceImpl;


@WebServlet("/AjaxDeleteBook.do")
public class AjaxDeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AjaxDeleteBook() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookServiceImpl();
		BookVO vo = new BookVO();
	
		vo.setBkCode(request.getParameter("bkCode"));
	
		Map<String, Object> map = new HashMap<>();

		if (service.deleteBook(vo)) {
			map.put("returnCode", "Success");
			map.put("result", vo);
		} else {
			map.put("returnCode", "Fail");
			map.put("result", "삭제 중 에러.");
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
