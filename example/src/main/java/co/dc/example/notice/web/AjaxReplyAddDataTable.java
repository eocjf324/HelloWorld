package co.dc.example.notice.web;

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

import co.dc.example.notice.service.ReplyService;
import co.dc.example.notice.service.ReplyVO;
import co.dc.example.notice.serviceImpl.ReplyServiceImpl;


@WebServlet("/AjaxReplyAddDataTable.do")
public class AjaxReplyAddDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxReplyAddDataTable() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeId = request.getParameter("noticeId");
		String content = request.getParameter("reply");
		String writter = request.getParameter("replyer");
		
		ReplyVO vo = new ReplyVO();

		vo.setNoticeId(Integer.parseInt(noticeId));
		vo.setReply(content);
		vo.setReplyer(writter);

		ReplyService service = new ReplyServiceImpl();

		Map<String, Object> map = new HashMap<>();
		if (service.addReply(vo)) {
			map.put("returnCode", "Succuss");
			map.put("data", vo);
		} else {
			map.put("returnCode", "Fail");
			map.put("data", "처리중 에러.");
		}

		Gson gson = new GsonBuilder().create();

		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(map));

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
