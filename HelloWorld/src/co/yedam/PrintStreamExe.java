package co.yedam;

import java.io.IOException;

public class PrintStreamExe {
	public static void main(String[] args) {
		//System.out.println("value>> ");
		
	
		
		try {
			while(true) {
				System.out.print("value>> ");
				int result = System.in.read();  //enter 13,10
				
				if(result !=13 && result != 10 ) {
					System.out.println("결과: " +result);
					 System.in.read();  //입력스트림값을 읽고 해당 키 반환.
					 System.in.read();
					 System.in.read();
					
				}
								
				if(result == 'q') {
					break;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("끝");
		
	}
}
