package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByeBufExe {
	public static void main(String[] args) throws IOException{
		//입력스트림.
		InputStream is = new FileInputStream("C:/temp/image.png");
		OutputStream os = new FileOutputStream("C:/temp/copy.png");
		
		System.out.println("start of prg.");
		byte[] buf = new byte[100];
		while(true) {
			int data = is.read(buf);
			os.write(buf);
			if(data == -1) {
				break;
			}
		}
		System.out.println("end of prg.");
		is.close();
		os.flush();
		os.close();
	}
}
