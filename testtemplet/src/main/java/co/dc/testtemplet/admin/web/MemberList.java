package co.dc.testtemplet.admin.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dc.testtemplet.common.ViewResolve;
import co.dc.testtemplet.member.service.MemberService;
import co.dc.testtemplet.member.service.MemberVO;
import co.dc.testtemplet.member.serviceImpl.MemberServiceImpl;


@WebServlet("/tables.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		
		members = dao.memberSelectList();
		request.setAttribute("members", members);
		
		String viewName = "admin/admin/list";
		ViewResolve.forward(request, response, viewName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
