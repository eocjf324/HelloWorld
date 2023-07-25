package co.yedam.typing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Type {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader("C:/Temp/wordAry.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {

				String str = br.readLine(); // 한문장씩 읽기.
				//str.trim();
				//str.replace("\"", "");
				//str.replace(",","");
				if (str == null) {
					break;
				}
				String[] data = str.split(" ");

				for (int i = 0; i < data.length; i++) {
//					
					data[i].trim();
					data[i].replace("\"", "");
					data[i].replace(",","");
					list.add(data[i]);
					
					
				}
				for(int i=0 ; i< list.size() ; i++) {
					System.out.print(list.get(i));
				}
			}
			
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
