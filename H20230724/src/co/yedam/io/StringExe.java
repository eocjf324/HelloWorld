package co.yedam.io;

import java.io.FileWriter;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("C:/temp/address.txt");
		Scanner scan = new Scanner(System.in);
		
		String temp = "";
		while(true) {
			System.out.print("입력>> ");
			temp = scan.nextLine();
			if(temp.equals("-1"))
				break;
			
			fw.write(temp + "\n");
			
		}
		fw.flush();
		fw.close();
		scan.close();
		System.out.println("종료.");
	}
}
