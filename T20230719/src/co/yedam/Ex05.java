package co.yedam;

import java.util.Scanner;

public class Ex05 {
	static Scanner scan = new Scanner(System.in);
	static Friend[] friends = new Friend[10];
	static int num = 0;
	public static void main(String[] args) {

		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.전화번호수정 4.삭제 5.종료");
			System.out.print("번호입력>");
			int choose = Integer.parseInt(scan.nextLine());

			if (choose == 1) {
				register();
			} else if (choose == 2) {
				list();
			} else if (choose == 3) {
				modify();
			} else if (choose == 4) {
				remove();
			} else if (choose == 5) {
				run = false;
				System.out.println("종료");
			}
		}
	}

	static void register() {
		System.out.println("등록");
		System.out.print("친구이름 전화번호 생년월일 키 입력>>>>");
		String name = scan.next();
		String phone = scan.next();
		String birth = scan.next();
		double height = Double.parseDouble(scan.next());
		scan.nextLine();

		Friend friend = new Friend(name, phone, birth, height);
	

		if (num > 10) {
			System.out.println("등록할 수 없습니다.");
		} else {
			friends[num++] = friend;
			System.out.println("등록되었습니다.");
		}
	
	}

	static void list() {
		System.out.println("목록");
		for(int i=0 ;i< friends.length; i++) {
			if(friends[i] != null) {
			System.out.println("친구이름:" + friends[i].getName() + " 전화번호:"+friends[i].getPhone()+" 생년월일:"+ friends[i].getBirth()+" 키:" +friends[i].getHeight() );
				
			}
		}
	}

	private static void remove() {
		System.out.println("삭제");
		System.out.print("친구이름>");
		String name = scan.nextLine();
	
		for(int i=0 ;i< friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i] = null;		
			}
		}
	}

	private static void modify() {
		System.out.println("수정");
		System.out.print("친구이름 수정할 전화번호>");
		String name = scan.next();
		String phone = scan.next();
		scan.nextLine();
		for(int i=0 ;i< friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);	
			}
		}
	}
}
