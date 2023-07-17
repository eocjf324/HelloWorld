package co.yedam.member;

import java.util.Scanner;

public class MemberExe {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean run = true;

		Member[] members = new Member[10];
	

		Member m1 = new Member();
		m1.setMemberNo(1001);
		m1.setMemberName("홍길동");
		m1.setPhone("010-1111");
		m1.setGender(Gender.MEN);
		m1.setAddress("대구 100");

		Member m2 = new Member();
		m2.setMemberNo(1002);
		m2.setMemberName("김길동");
		m2.setPhone("010-2222");
		m2.setGender(Gender.WOMEN);
		m2.setAddress("대구 200");

		members[0] = m1; // 등록
		members[1] = m2;

		Member m3 = new Member();
		members[2] = m3;

		Member m4 = new Member(3001, "용용","010-47474",Gender.WOMEN,"대구 123");
		members[3] = m4;

		while (run) {
			Member member = new Member();
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.상세조회 6.남자회원목록 7.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scan.nextLine());
			if (menu == 1) {
				System.out.println("등록기능.");
				System.out.print("회원번호입력>");
				int mNo = Integer.parseInt(scan.nextLine());
				System.out.print("회원이름입력>");
				String mName = scan.nextLine();
				System.out.print("회원연락처입력>");
				String phone = scan.nextLine();
				System.out.print("회원성별입력>");
//startsWith <----- 문자 시작 느낌!!!!!! 				
				// 남, 남자 startsWith("
				Gender gender = null;
				String temp = scan.nextLine();
				if (temp.startsWith("남")) {
					gender = Gender.MEN;
				} else if (temp.startsWith("여")) {
					gender = Gender.WOMEN;
				}
				System.out.print("회원주소입력>");
				String address = scan.nextLine();
				member.setMemberNo(mNo);
				member.setMemberName(mName);
				member.setPhone(phone);
				member.setGender(gender);
				member.setAddress(address);

				// members 멤버인스턴스 10개저장.

				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member; // 배열의 빈값에 저장
						break; // 한건 저장후 반복문 종료.
					}
				}
			} else if (menu == 2) {
				System.out.println("목록기능.");
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						System.out.println(members[i].showInfo());

					}
				}
			} else if (menu == 3) {
				System.out.println("수정기능.");
				System.out.print("회원번호입력>> ");
				int no1 = Integer.parseInt(scan.nextLine());
				boolean check = true;

				for (int i = 0; i < members.length; i++) {
					if (members[i] != null && members[i].getMemberNo() == no1) {
						System.out.print("수정할 연락처 입력>> ");
						String no2 = scan.nextLine();
						members[i].setPhone(no2);
						System.out.println("수정되었습니다.");
						check = false;
					}
				}
				if (check == true) {
					System.out.println("회원번호가 없습니다.");
				}

			} else if (menu == 4) {
				boolean check = true;
				System.out.println("삭제기능.");
				System.out.print("회원번호입력>> ");
				int no = Integer.parseInt(scan.nextLine());
				for (int i = 0; i < members.length; i++) {
					// 배열의 값중에서 null 여부 체크.
					if (members[i] != null && members[i].getMemberNo() == no) {
						members[i] = null;
						check = false;
						System.out.println("삭제되었습니다.");
					}
				}
				if (check == true) {
					System.out.println("회원번호가 없습니다.");
				}

			} else if (menu == 5) {
				System.out.println("상세조회기능.");
				System.out.println("회원번호입력>> ");
				int no = Integer.parseInt(scan.nextLine());

				for (int i = 0; i < members.length; i++) {
					// 배열의 값중에서 null 여부 체크.
					if (members[i] != null && members[i].getMemberNo() == no)
						System.out.println(members[i].detailInfo());

				}
			} else if (menu == 6) {
				System.out.println("남자조회기능.");
				for (int i = 0; i < members.length; i++) {
					// 배열의 값중에서 null 여부 체크.
					if (members[i] != null && members[i].getGender() == Gender.MEN)
						System.out.println(members[i].showInfo());

				}

			} else {
				System.out.println("종료기능.");
				run = false;
			}

		}
		System.out.println("end of prog.");
	}
}
