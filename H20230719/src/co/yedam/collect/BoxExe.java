package co.yedam.collect;

public class BoxExe {
	public static void main(String[] args) {
		Box<String>box = new Box<String>();
		
		box.set("오렌지");
		String result = box.get();
		
		Box<Integer> ibox = new Box<>();
		
		ibox.set(100);
		int iresult = ibox.get();
		
		System.out.println(result);
	}
}
