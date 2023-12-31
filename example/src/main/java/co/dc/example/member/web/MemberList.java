package co.dc.example.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dc.example.common.ViewResolve;
import co.dc.example.member.service.MemberService;
import co.dc.example.member.service.MemberVO;
import co.dc.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberlist.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberList() {
        super();  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();

		members = dao.memberSelectList();
		request.setAttribute("members", members);

		String viewName = "member/memberlist";
		ViewResolve.forward(request, response, viewName);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
