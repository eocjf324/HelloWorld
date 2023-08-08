package co.kh.execsample.member.Web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.kh.execsample.common.ViewResolve;
import co.kh.execsample.member.service.MemberService;
import co.kh.execsample.member.service.MemberVO;
import co.kh.execsample.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/memberjoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberJoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요기다 파일 업로드 및 데이터 관리를 한다.
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String saveDir = getServletContext().getRealPath("/attech/member/"); // 리눅스 유닉스 / 윈도우 \ file.separator = 지가 알아숴 바꿔줌  
		int sizeLimit = 100 * 1024 * 1024; // 파일사이즈 지정
		

		MultipartRequest multi = new MultipartRequest(request, saveDir, sizeLimit, "utf-8",
				new DefaultFileRenamePolicy());

		String orginalFileName = multi.getOriginalFileName("file");
		if (orginalFileName != null) {
			String fileName = multi.getFilesystemName("file"); // 물리적 위치에 저장 (savedir에 저장)
			vo.setMemberImg(fileName);
		}

		vo.setMemberId(multi.getParameter("memberId"));
		vo.setMemberPassword(multi.getParameter("memberPassword"));
		vo.setMemberName(multi.getParameter("memberName"));
		vo.setMemberTel(multi.getParameter("memberTel"));
		vo.setMemberAddress(multi.getParameter("memberAddress"));

		int n = dao.memberInsert(vo); // 리턴 되면 1이 들어오겠지?
		if (n != 0) {
			request.setAttribute("message", "회원가입이 정상적으로 처리되었다잉");
		} else {
			request.setAttribute("message", "회원가입 실패ㅋ");
		}

		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
