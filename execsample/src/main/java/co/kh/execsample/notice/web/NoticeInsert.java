package co.kh.execsample.notice.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.kh.execsample.common.ViewResolve;
import co.kh.execsample.notice.service.NoticeService;
import co.kh.execsample.notice.service.NoticeVO;
import co.kh.execsample.notice.serviceImpl.NoticeServiceImpl;


@WebServlet("/noticeinsert.do")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeInsert() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = getServletContext().getRealPath("attech/notice/");
		int sizeLimit = 100 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(
						request, 
						saveDir,
						sizeLimit,
						"utf-8",
						new DefaultFileRenamePolicy());
		
		String orininalFile = multi.getOriginalFileName("file");//물리적 위치에 저장
		if(orininalFile != null) {
			String fileName = multi.getFilesystemName("file");
			vo.setNoticeAttech(orininalFile);
			vo.setNoticeAttechDir(saveDir + fileName);
		}
		
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));
		
		int n = dao.noticeInsert(vo);
		if( n == 1) {
			request.setAttribute("message", "게시글이 등록 OOOO");
		}else {
			request.setAttribute("message", "게시글이 등록 XXXX");
		}
		
		String viewName = "notice/noticemessage";
		
		ViewResolve.forward(request, response, viewName);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
