package co.yedam.interfaces;

//인터페이스.
//생성자(x), 필드(O) : 상수로 사용, 메소드: 추상메소드로 선언.
public interface RemoteCon {
	final int CHANNEL = 10;  //값 변경x final 안붙여도 됨
	
	
	abstract void turnOn();  //abstract 안붙여도 추상메소드 
	void turnOff();
	
	
}
