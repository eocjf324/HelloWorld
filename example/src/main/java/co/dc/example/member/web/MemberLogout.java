package co.dc.example.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dc.example.common.ViewResolve;


@WebServlet("/memberlogout.do")
public class MemberLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberLogout() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();

		String name = (String) session.getAttribute("name");
		session.invalidate();
		request.setAttribute("message", name + "님 로그아웃이 정상적으로 처리됨");
		String viewName = "member/membermessage";

		ViewResolve.forward(request, response, viewName);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
