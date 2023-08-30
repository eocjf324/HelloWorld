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

import co.dc.example.ajax.service.MembersService;
import co.dc.example.ajax.serviceImpl.MembersServiceImpl;


@WebServlet("/ajaxmemberdel.do")
public class AjaxMemberDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjaxMemberDel() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersService service = new MembersServiceImpl();
	
		String no = request.getParameter("no");
		
		Map<String, Object> map = new HashMap<>();

		if (service.deleteMember(Integer.parseInt(no))) {
			map.put("returnCode", "Success");
			map.put("result", "삭제 성공");
		} else {
			map.put("returnCode", "Fail");
			map.put("result", "삭제 실패");
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
