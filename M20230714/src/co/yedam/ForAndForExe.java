package co.yedam;

public class ForAndForExe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		practice3();
		practice4();
	}
	
	public static void forAndFor() {
		for(int i = 1; i <= 9 ; i++) {
			for(int j = 1; j <= 9;j++){
				System.out.printf("%d X %d = %2d   ", j, i, i * j);
			}
			System.out.println();
		}
	}
	
	public static void practice3() {
		
		while(true) {
			
			int num1 = (int)(Math.random() * 6) + 1 ;
			int num2 = (int)(Math.random() * 6) + 1 ;
			
			if(num1 + num2 ==5) {
				System.out.printf("(%d, %d)\n",num1,num2);
				break;
			}
			

		}
	}
	public static void practice4() {
		
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if(4 * x + 5 * y == 60) {
					System.out.printf("x = %2d, y=> %2d\n", x,y);
				}
				
			}
		}
	}
}
