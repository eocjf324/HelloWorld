package co.yedam.friend;

import java.util.Scanner;

public class AddressAppExe {
	public static void main(String[] args) {

		// 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료
		Scanner scan = new Scanner(System.in);
		AddressApp app = new AddressApp();
		String name;
		String phone;
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
			System.out.print("번호입력>");
			int choose = Integer.parseInt(scan.nextLine());

			if (choose == 1) {
				System.out.println("등록");
				System.out.println("1.친구 2.회사 3.학교");
				System.out.print("번호입력>");
				int choose2 = Integer.parseInt(scan.nextLine());
				if (choose2 == 1) {
					System.out.print("친구(이름 폰번호 2개 입력)>>");
					name = scan.next();
					phone = scan.next();
					scan.nextLine();

					
					if (app.addFriend(new Friend(name, phone))) {
						System.out.println("등록되었습니다.");
					} else {
						System.out.println("등록되지못했습니다.(저장공간 초과)");
					}
				} else if (choose2 == 2) {
					System.out.println("회사");
					System.out.print("친구(이름 폰번호 회사 부서 4개 입력)>>");
					name = scan.next();
					phone = scan.next();
					String company = scan.next();
					String dept = scan.next();
					scan.nextLine();

					if (app.addFriend(new Company(name, phone, company, dept))) {
						System.out.println("등록되었습니다.");
					} else {
						System.out.println("등록되지못했습니다.(저장공간 초과)");
					}
				
				} else if (choose2 == 3) {
					System.out.println("학교");
					System.out.print("친구(이름 폰번호 학교 전공 4개 입력)>>");
					name = scan.next();
					phone = scan.next();
					String school = scan.next();
					String major = scan.next(); 
					scan.nextLine();

					if (app.addFriend(new School(name, phone, school, major))) {
						System.out.println("등록되었습니다.");
					} else {
						System.out.println("등록되지못했습니다.(저장공간 초과)");
					}
				}
			} else if (choose == 2) {
				System.out.println("목록");
				Friend[] ary = app.friendList();

				for (int i = 0; i < ary.length; i++) {
					if (ary[i] != null) {
						System.out.println(ary[i].showInfo());
					}
				}
			} else if (choose == 3) {
				System.out.println("수정");
				System.out.println("이름입력>");
				name = scan.nextLine();
				System.out.println("폰번호 입력>");
				phone = scan.nextLine();
				
				if(app.editFriend(name, phone)) {
					System.out.println("수정되었습니다.");
				}else {
					System.out.println("수정되지않았습니다.(회원번호가 없습니다.)");
				}
				
			} else if (choose == 4) {
				System.out.println("삭제");
				System.out.println("이름입력>");
				name = scan.nextLine();
				if(app.delFriend(name)) {
					System.out.println("수정되었습니다.");
				}else {
					System.out.println("수정되지않았습니다.(회원번호가 없습니다.)");
				}
			} else if (choose == 5) {
				System.out.println("단건조회");
				System.out.println("이름입력>");
				name = scan.nextLine();
				
				Friend view = app.findFriend(name);
			
				if(view == null) {
					System.out.println("조회불가(회원번호가 없습니다.)");
				}else {
					System.out.println(view.showInfo());
				}
			} else if (choose == 6) {
				run = false;
				System.out.println("종료");
			}
		}

	}// end of main
	
//	static String prompString(String msg) {
//		
//	}
//	AddressApp app = new AddressApp();
//	
//	System.out.println(app.show(new Friend("친구","0144")));
//	System.out.println(app.show(new Company("회사친구","010-101010", "교보","인사")));
//	System.out.println(app.show(new School("학교친구","010-1122","예담","컴공")));
//
//	// Friend <- Company, school 
//	Friend[] friend = new Friend[10];
//	//friends 배열에 Friend 클래스의 인스턴스 대입.
//	friend[0] = new Friend("홍길동","010-1111-2222");
//	friend[1] = new Company("김길동","010-8888-1111", "교보","인사");
//	friend[2] = new School("신길동","010-5550-2222", "예담","컴공");
//	
//	for(int i = 0; i< friend.length ;i++) {
//		if(friend[i] != null) {
//			//System.out.println(app.show(friend[i]));
//			System.out.println(friend[i].showInfo()); //메소드재정의에 의한 showInfo실행.
//		}
//	}

}
