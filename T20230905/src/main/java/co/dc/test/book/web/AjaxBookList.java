package co.dc.test.book.web;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/AjaxbookList.do")
public class AjaxBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AjaxBookList() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService service = new BookServiceImpl();
		List<BookVO> list = service.bookList();
	
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
