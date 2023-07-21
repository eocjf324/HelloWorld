package co.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello,Word,Nice";
		String[] strAry = str.split(",");
		int cnt =0;
		for(String word : strAry) {
			System.out.println(word);
			if(word.indexOf("o") > -1) {
				cnt++;
			}
		}
		System.out.println("o 를 포함한 단어수: " + cnt);
	}
}
