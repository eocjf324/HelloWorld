package co.yedam.friend;

//친구의 연락처 관리 app.
//일반적인 정보: 이름, 연락처.
//회사의 정보(회사,부서), 학교의 정보(학교,전공),
//System.out.plrintln() : 콘솔 x.
public class AddressApp {

	Friend[] friends = new Friend[10]; // 저장공간.
	int num = 0;
	//Friend friend = new Friend();

	// 추가. addFriend()
	public boolean addFriend(Friend friend) {
		if (num > 10) {
			return false;
		} else {
			friends[num++] = friend;
			return true;
		}
	}

	// 조회. findFriend() :친구이름중에는 동일한 이름이 없음.
	public Friend findFriend(String name) {
		
		for (int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				return friends[i];
			}
		}
		return null;
	}

	// 수정. editFriend() : 친구의 연락처 수정.
	public boolean editFriend(String name, String phone) {
		
		for(int i = 0; i< friends.length ; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
				return true;
			}
		}
		return false;
	}
	//삭제. delFriend() :친구의 정보 삭제
	public boolean delFriend(String name) {
		for(int i = 0; i< friends.length ; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i] = null;
				return true;
			}
		}
		return false;
	}
	
	//목록 friendList()
	public Friend[] friendList() {
		
		return friends;
	}
	
//  노쓸모	
//	public String show(Friend friend) {
//		return friend.showInfo();
//	}

}
