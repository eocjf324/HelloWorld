package co.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateToStr(Date date) {
		// Date -> String 변환.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}

	public static String dateToStr(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date strToDate(String string) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat(string);
		Date date = new Date();
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


}
