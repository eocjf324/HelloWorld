package co.yedam;

//H20230714 proj.
public class ConditionExe {
	public static void main(String[] args) {
		int score = 100;
//		// 90점이상 A, 80=> B, 70 => C, 그 외 D
//		if (score >= 90) {
//			System.out.println("A학점입니다.");
//		} else if (score >= 80) {
//			System.out.println("B학점입니다.");
//		} else if (score >= 70) {
//			System.out.println("C학점입니다.");
//		} else {
//			System.out.println("D학점입니다.");
//		}
		
		switch(score/10) {
		case 9:
		case 10:
			System.out.println("A학점입니다."); break;
		case 8: 
			System.out.println("B학점입니다.");break;
		case 7:
			System.out.println("C학점입니다.");break;
		default:
			System.out.println("D학점입니다.");
		}
	}// end of main()
}
