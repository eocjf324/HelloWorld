package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe {
	public static void main(String[] args) {
		//NullPointException.
		
		Scanner scan = new Scanner(System.in);
		String str = null;
		str = "홍길동";
		int age =0;
		//try 블럭에서 예외가 발생하면 
		//catch 블럭에 정의된 코드실행.
		
		try {
			System.out.println(str.toString());	
			age = Integer.parseInt(scan.nextLine());
			System.out.println("이름은 " + str + ", 나이는 " + age);
		}catch(NullPointerException | NumberFormatException e) {
			System.out.println("Null 예외 발생.");
//		}catch(NumberFormatException n) {
//			System.out.println("Format 예외가 발생.");
		}finally {
			scan.close(); // 리소스 반환.
		}
		
		try {
			//Class cls = Class.forName("java.lang.String");
			exceptionMethod();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end of prog");
	}
	
	public static void exceptionMethod() throws ClassNotFoundException {
		
		//예외처리의 책임을 메소드를 호출한 영역으로 떠넘기기 
		Class cls = Class.forName("java.lang.String");	
	}
}
