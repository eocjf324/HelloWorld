package co.yedam.collect;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExe {
	public static void main(String[] args) {
		Map<String, String> users = new Hashtable<>();
		
		users.put("spring", "12");
		users.put("summer", "123");
		users.put("fall", "1234");
		users.put("winter", "12345");
		
		Scanner scan = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			System.err.println("아이디와 비밀번호를 입력(ex)>>>");
			System.out.print("아이디>> ");
			String id = scan.nextLine();
			System.out.print("비번>> ");
			String pwd = scan.nextLine();
			
			if(users.containsKey(id)) {
				if(users.get(id).equals(pwd)) {
					System.out.println("로그인성공..");
					run = false;
				}else {
					System.out.println("비밀번호가 다릅니다.");
				}
				
			}else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
		}//end of while
		
		System.out.println("프로그램을 시작합니다.");
	}//end of main
}
