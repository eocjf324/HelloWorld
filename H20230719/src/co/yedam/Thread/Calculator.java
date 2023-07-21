package co.yedam.Thread;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	public synchronized void setMemory(int memory) {
		
		//임계영역 : 하나의 쓰레드만 허용
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ " : " + this.memory);
	}
}
