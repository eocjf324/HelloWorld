package co.dc.project.boardprj.member.Service;

public interface MemberService {

	int memberInsert(MemberVO vo); 		// 회원가입
	int memberDelete(MemberVO vo); 		// 회원탈퇴
	MemberVO memberSelect(MemberVO vo); // 개인정보 조회
	boolean idCheck(String id);    		// 로그인 확인 , 아이디 생성시 중복 확인
	boolean passwordCheck(String pw);   // 로그인 확인 
 
}
