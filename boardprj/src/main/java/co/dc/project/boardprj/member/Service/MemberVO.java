package co.dc.project.boardprj.member.Service;


import lombok.Data;

@Data
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberTel;
	private String memberAddress;

	@Override
	public String toString() {
		System.out.print(memberId + "\t ");
		System.out.print(memberName + "\t ");
		if(memberPassword != null) {
			System.out.print(memberPassword);
		}
		System.out.print(memberAge + "\t ");
		System.out.print(memberGender + "\t ");
		System.out.print(memberTel + "\t\t ");
		System.out.println(memberAddress + "\t ");
		
		return null;
	}
	
	public MemberVO() {};
	
	public MemberVO(String memberId, String memberPassword, String memberName, int memberAge, String memberGender,
			String memberTel, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberGender = memberGender;
		this.memberTel = memberTel;
		this.memberAddress = memberAddress;
	}
	
}
