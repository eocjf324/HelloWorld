package co.yedam.api;

public class Member {
	int memberNo;
	String memberName;

	public Member(int memberNo, String memberName) {
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
	
	@Override
	public int hashCode() {
		return this.memberName.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Member) {
			Member m2 = (Member) obj;
			return this.memberNo == (m2.memberNo);
			
		}else {
			return false;
		}
	
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + "]";
	}
}
