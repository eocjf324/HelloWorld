package co.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date today = new Date();
		// Date -> String
		System.out.println(sdf.format(today));

		Date tday = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			tday = sdf.parse("2023-01-10 10:10:20");
			System.out.println(tday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//데이트 -> 문자열 변환
		String result = DateUtil.dateToStr(tday);
		System.out.println(result);
		
		
		//데이트 -> 문자열 변환 , 패턴넣고
		result = DateUtil.dateToStr(tday, "yyyy-MM-dd");
		System.out.println(result);
		
		
		//문자열(2023-03-05) => Tue Mar 05 00:00:00 KST 2023
		Date date = DateUtil.strToDate("2023-03-05");
		System.out.println("문자열 날짜를 데이트로 변환 :" +date);
	}//end main
	
	
}

