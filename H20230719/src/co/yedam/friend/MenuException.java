package co.yedam.friend;

public class MenuException extends Exception {

	int choice;
	
	
	public MenuException(int Choice) {
		this.choice =  Choice;
	}
	
	public void showMessage() {
		System.out.println(choice + "는 잘못된 메뉴값입니다.");
	}
}
