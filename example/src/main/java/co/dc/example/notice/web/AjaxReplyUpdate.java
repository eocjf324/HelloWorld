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


@WebServlet("/AjaxReplyUpdate.do")
public class AjaxReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AjaxReplyUpdate() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String replyId = request.getParameter("replyId");
		String reply = request.getParameter("reply");
		String replyer = request.getParameter("replyer");
		
		ReplyVO vo = new ReplyVO();

		vo.setReplyId(Integer.parseInt(replyId));
		vo.setReply(reply);
		vo.setReplyer(replyer);

		ReplyService service = new ReplyServiceImpl();

		Map<String, Object> map = new HashMap<>();
		if (service.eidtReply(vo)) {
			map.put("returnCode", "Succuss");
			map.put("data", "처리 성공");
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
