package co.yedam;

public class prepared {

	public static void main(String[] args) {
		
		
		solution(1,2,3,4);
		solution(9,2,1,3);
	
		

	}
	
	public static int[] solution(int numer1, int denom1, int numer2, int denom2 ) {
		int[] answer = new int[2];
		
		int numer = numer1 * denom2 + numer2 * denom1;
		int denom = denom1 * denom2;
		

		for(int i = 2; i< 1000; i++) {
			if(numer % i == 0 && denom % i ==0) {
				numer /= i;
				denom /= i;
			}
		}
		answer[0] = numer;
		answer[1] = denom;
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
		return answer;
	}

}
