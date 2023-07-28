package co.dc.project.boardprj.member.Service;

public interface MemberService {
	
	int memberInsert(MemberVO vo);   //회원가입
	int memberUpdate(MemberVO vo);   //회원수정(뭘 수정할까 ( 이름,주소,전화번호)
	int memberDelete(MemberVO vo);   //회원삭제
	MemberVO memberSelect(MemberVO vo);
	MemberVO searchId(MemberVO vo);  	  //아이디 찾기(전화번호 입력받기)
	MemberVO searchPassword(MemberVO vo); // 비밀번호 찾기(아이디, 추가로 이름해도되고)
	MemberVO checkId(MemberVO vo); 		  //로그인 아이디 확인
	MemberVO checkPassword(MemberVO vo);   // 로그인할때 비밀번호 확인
}
