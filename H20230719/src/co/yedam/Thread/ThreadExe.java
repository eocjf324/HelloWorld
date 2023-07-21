package co.yedam.Thread;

import java.awt.Toolkit;

class PrintThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("print");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//2
class BeepTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class ThreadExe {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		
		//화면 print 출력. beep출력.
		
		PrintThread thread = new PrintThread();
		thread.start(); // run 메소드 실행
//		Thread bthread = new Thread(new BeepTask()); //2
//		bthread.start(); // run 메소드 실행
		
		Thread bthread = new Thread( () -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		});
		bthread.start(); // run 메소드 실행


		System.out.println("end of prog");
	}
}
