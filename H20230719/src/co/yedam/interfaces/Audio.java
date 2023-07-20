package co.yedam.interfaces;

//RemoteCon 인터페이스 구현하는 클래스.
public class Audio implements RemoteCon {
	
	double freq;
	
	public Audio() {
		
	}
	public void setFreq(double freq) {
		this.freq = freq;
	}
	
	
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Audio 전원 켬.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Audio 전원 끔.");
	}

}
