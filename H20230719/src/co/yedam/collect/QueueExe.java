package co.yedam.collect;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExe {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		que.offer("홍길동");
		que.offer("최길동");
		que.offer("황길동");
		
		System.out.println(que.poll());
		System.out.println(que.poll());
	}
}
