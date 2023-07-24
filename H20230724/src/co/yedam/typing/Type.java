package co.yedam.typing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Type {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		try {
			FileReader fr = new FileReader("C:/temp/wordAry.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {

				String str = br.readLine(); // 한문장씩 읽기.

				if (str == null) {
					break;
				}
				String[] data = str.split(" ");

				for (int i = 0; i < data.length; i++) {
				
					list.add(str);
				}
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
