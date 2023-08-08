package co.kh.execsample.member.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.execsample.member.service.MemberService;
import co.kh.execsample.member.service.MemberVO;
import co.kh.execsample.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class AjaxMemberIdCheck
 */
@WebServlet("/ajaxMemberIdCheck.do")
public class AjaxMemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMemberIdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		
		vo = dao.memberSelect(vo);
		String txt = "yes"; // 사용 가능한 아이디
		if(vo != null) {
			txt = "no"; // 사용 불가능한 아이디
		}
		response.setContentType("text/html; charset=UTF-8"); // 리스폰 콘텐트타입 지정
		response.getWriter().append(txt); // 호출한 페이지에 출력해라
		return; // 그리고 리턴해라
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
