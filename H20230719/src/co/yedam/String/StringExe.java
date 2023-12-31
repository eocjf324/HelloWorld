package co.yedam.String;

import java.io.IOException;

public class StringExe {
	public static void main(String[] args) {

		String[] numbers = {"9802031234567", "0502033234567", "980202-1234567", "990203-2234567", "020203 1234567",
				"032303 2234557" };             

		// 주민번호 뒷자리의 첫번째 값(성별: 1,3 남자/ 2,4 여자)
		//	~1999 >    < 2000~
		// 알고리즘 -> 앞에 문자 2개로 99년 이전이면 1,2 00 이후로 3,4 확인
		
		for (String num : numbers) {
			System.out.println(checkGender(num));
		}
	}

	static String checkGender(String no) {
		
		String no2 = no.replace("-", "");  //하이픈 제거
		String no3 = no2.replace(" ","");  //공백 제거
		
		String year  = no3.substring(0, 2); //출생년도 
		String check = no3.substring(0, 1); //성별 확인
		char gender  = no3.charAt(6);       //성별 체크 
		System.out.printf("출생년도 : %s, 성별확인 : %c\n", year, gender);
		System.out.println(no3);
		
		if (check.equals("9") ) {
			switch (gender) {
			case '1':
				return "남";
			case '2':
				return "여";
			default:
				return "에러";
			}

		} else {
			switch (gender) {
			case '3':
				return "남";
			case '4':
				return "여";
			default:
				return "에러";
			}
		}
	}
}
