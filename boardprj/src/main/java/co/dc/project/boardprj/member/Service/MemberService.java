package co.dc.project.boardprj.member.Service;

public interface MemberService {
	
	int memberInsert(MemberVO vo);   //회원가입
	int memberUpdate(MemberVO vo);   //회원수정
	int memberDelete(MemberVO vo);   //회원삭제
	MemberVO memberSelect(MemberVO vo); //개인정보 조회
	boolean memberCheck(String id, String pw); 

}
