package co.yedam;

public class Ex03 {
	public static void main(String[] args) {
		
		int[] array = new int[5];
		int max=0;
		int min=0;
		
		for(int i =0; i< array.length; i++) {
			array[i] = (int)(Math.random() * 10) +1;
			System.out.println(array[i]);
		}
		
		max = array[0];
		min = array[0];
		for(int i = 1 ; i< array.length ; i++) {
			if(array[i] > max){
				max = array[i];
			}
			if(array[i] < min) {
				min = array[i];
			}
		}
		System.out.printf("최대값: %d 최소값: %d", max, min);
					
	}
}
