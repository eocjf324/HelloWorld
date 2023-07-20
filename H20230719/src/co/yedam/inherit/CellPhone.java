package co.yedam.inherit;

public class CellPhone {
	
	//필드(속성)
	private String model;
	private String color;
	
	
	//기본생성자를 컴파일러가 생성.
	public CellPhone() {
		
	}
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	//메소드(기능)
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void powerOn() {
		System.out.println("전원켭니다");
	}
	public void powerOff() {
		System.out.println("전원켭니다");
	}
	public void sendMessage(){
		System.out.println("메세지전송");
	}
	public void reseiveMessage(){
		System.out.println("메세지수신");
	}
	
	public String showInfo() {
		return "모델명: " + model + ", 색상: " + color;
	}
	
}
