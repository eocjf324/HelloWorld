package co.dc.example.notice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dc.example.common.ViewResolve;
import co.dc.example.notice.service.NoticeService;
import co.dc.example.notice.service.NoticeVO;
import co.dc.example.notice.serviceImpl.NoticeServiceImpl;


@WebServlet("/noticeditform.do")
public class NoticeEditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeEditForm() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId"))); //폼에서 넘어온값은 string!
		vo = dao.noticeSelect(vo);
		
		request.setAttribute("n", vo);
		String viewName = "notice/noticeditform";
		ViewResolve.forward(request, response, viewName);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
