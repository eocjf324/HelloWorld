package co.dc.example.notice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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


@WebServlet("/AjaxDatatable.do")
public class AjaxDatatable extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AjaxDatatable() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReplyService svc =new ReplyServiceImpl();
		List<ReplyVO> list = svc.replylist(Integer.parseInt(request.getParameter("noticeId")));
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("data", list);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ReplyService svc =new ReplyServiceImpl();
		//List<ReplyVO> list = svc.replylist(6);
		
		String json = "{\"data\":[";
	/*//	for(int i =1; i<= 75; i++) {
		int cnt = list.size();
		for(int i=0; i<list.size(); i++) {
			json += "[\"" + list.get(i).getReplyId()+"\",\"" 
				 +list.get(i).getReply()+ "" + i + "\","
				 + "\"" + list.get(i).getReplyer() +
				 "\", \"" + list.get(i).getReplyDate() + "\"]";
			if(i != (cnt -1)) {
				json += ",";
			}
		}*/
		//json += "]}";
		doGet(request, response);
	}

}
