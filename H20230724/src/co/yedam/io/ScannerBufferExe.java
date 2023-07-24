package co.yedam.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

// 이름/주소/연락ㅊ러 -> 3건 입력. C:/temp/address2.txt
public class ScannerBufferExe {

	public static void main(String[] args) throws Exception {
		 
	
		Scanner scan = new Scanner(System.in);
		FileWriter fw = new FileWriter("C:/temp/address2.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		while(true){
			System.out.print("이름 주소 연락처 입력>>");
			String str = scan.nextLine();
			
			if(str.equals("-1"))
				break;
			
			bw.write(str + "\n");
		}
		bw.flush();
		bw.close();
		fw.close();
		scan.close();
		
		System.out.println("종료");
		
	}
	
}
