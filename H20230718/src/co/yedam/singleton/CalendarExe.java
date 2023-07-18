package co.yedam.singleton;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExe {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String str;
		System.out.println("input(번호 이름 성적)>>>");
		
		String no = scan.next();
		String name = scan.next();
		String score =scan.next();
		System.out.println("번호: " + no + ", 이름: " + name +", 성적: " +score);
		
//		str = scan.nextLine();
//		System.out.println(str);
		
		
//		while(true){
//			if(scan.hasNext()) {
//				str =scan.next();
//				System.out.println(str);
//				continue;
//			}
//			break;
//		}
		
		//showCal(2023, 8);

	}

	public static void showCal(int year, int month) {
		// System.out.println(Calendar.YEAR);
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);

		System.out.println("년도: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("날짜: " + cal.get(Calendar.DATE));
		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("말일: " + cal.getActualMaximum(Calendar.DATE));
////////////////////////////////////////////////////////////////////////////
		// 달력그리기
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };

		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();

		int pos = cal.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = 0; i < pos; i++) {
			System.out.printf("%4s", "");
		}
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + pos) % 7 == 0) {//이부분이해하기
				System.out.println();
			}
		}

	}
}
