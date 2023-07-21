package co.yedam.Thread;

public class MainThread {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start(); // calculator.memory = 100;
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start(); // calculator.memory = 50;
	}
}
