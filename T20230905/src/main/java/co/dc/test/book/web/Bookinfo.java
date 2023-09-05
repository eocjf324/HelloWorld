package co.dc.test.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dc.test.common.ViewResolve;


@WebServlet("/bookinfo.do")
public class Bookinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Bookinfo() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewName = "WEB-INF/views/book/bookinfo";
		ViewResolve.forward(request, response, viewName);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
