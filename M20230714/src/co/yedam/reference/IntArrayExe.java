package co.yedam.reference;

public class IntArrayExe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		array2();
		
	}

	public static void array2() {
		// 정수를 저장할 수 있는 배열 scores.
		// 학생1 ~ 5: 80, 85, 77, 93, 100
		// 학생점수의 합과 평균.
		int[] array = { 80, 85, 77, 93, 100 };

		int sum = 0;
	
		;
		for (int num : array) {
			sum += num;
		}
		double avg = (double) sum / array.length;

		System.out.printf("학생 점수 합: %d, 평균: %.1f", sum, avg);

	}

	public static void array() {
		int[] intAry = { 10, 20, 30 };
		intAry = new int[] { 10, 20, 30 }; // 정수형 배열 3개 크기
		intAry = new int[5]; // 정수형 배열 공간 5개 크기

		intAry[0] = 15;
		intAry[intAry.length - 1] = 55;

		int sum = 0;
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
			sum += intAry[i];
		}
		System.out.println("sum: " + sum);

		// 확장 for.

		for (int num : intAry) {
			System.out.println(num);
			sum += num;
		}
		System.out.println("sum: " + sum);
	}

}
