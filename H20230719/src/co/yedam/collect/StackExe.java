package co.yedam.collect;

import java.util.Stack;

public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("홍길동");
		stack.push("김길동");
		stack.push("박길동");

		while ( !stack.isEmpty()) {
			System.out.println(stack.pop());

		}
	}
}
