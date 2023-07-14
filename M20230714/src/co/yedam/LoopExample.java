package co.yedam;

public class LoopExample {
	static int value;
	public static void main(String[] args) {
		// 76800원  > 5만원:1장, 2만원:2장 , 5천원 :1장 천원:1장, 500원 하나, 100원 3개
		

		
		money();
		
	}
	
	public static void money() {
		int oman, man, ochun, chun, obac, bac;
		int temp;
		
		for(int i= 1;i< 10; i++) {
			value =( (int)(Math.random() * 50000 / 100)) * 100 + 50000;
		}
		oman = value / 50000;          
		temp = value - (oman * 50000);
		
		man = temp / 10000;
		temp -= man * 10000;
		
		ochun = temp/ 5000;
		temp -= ochun * 5000;
		
		chun = temp / 1000;
		temp -= chun * 1000;
		
		obac = temp/ 500;
		temp -= obac * 500;
		
		bac = temp/ 100;
		temp -= bac * 100;
		
	
		System.out.printf("%d원은 50000원 %d장, 10000원 %d장, 5000원 %d장, 1000원 %d장, 500원 %d개, 100원 %d개",value
				,oman,man,ochun,chun, obac, bac);
	}
}
