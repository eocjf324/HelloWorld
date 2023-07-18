package co.yedam;

public class ForConditionExe {

	public static void main(String[] args) {
		showCalendar(6);

	} // end of main()
	
	public static void showCalendar(int month) {
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		// TODO Auto-generated method stub

		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
	
//1일의 위치 지정.
		int pos = getFirstDate(month);
		for (int i = 0; i < pos; i++) {
			System.out.printf("%4s", "");
		}
		int lastDate = getLastDate2(month);
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + pos) % 7 == 0) {
				System.out.println();
			}
		}
		
	}
	
	//월 정보를 입력하면 해당월의 1일의 위치(공란을 반환)
	public static int getFirstDate(int month) {
		int pos = 1;
		switch(month) {
		case 5:
			pos = 1;break;
		case 6:
			pos = 4;break;
		case 7:
			pos = 6;break;
		case 8:
			pos = 2;break;	
		}
		return pos;
	}

	// 월 정보를 입력하면 해당월의 마지막날을 반환.
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
		}
		return lastDate;
	}
	public static int getLastDate2(int month) {
		int lastDate =31;
		
		if(month == 2) {
			lastDate = 28;
		}
		else if(month == 4) {
			lastDate = 30;
		}
		else if(month == 6) {
			lastDate = 30;
		}
		else if(month == 9) {
			lastDate = 30;
		}
		else if(month == 11) {
			lastDate = 30;
		}
		
		return lastDate;
	}
} //end of class