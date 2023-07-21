package co.yedam.collect;

import java.util.ArrayList;
import java.util.List;

import co.yedam.friend.Friend;

public class ArrayListExe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List list = new ArrayList();
//		
//		list.add("홍길동");
//		list.add(10);
//		list.add(new Friend("김길동", "010-1111"));
//	
//		String obj = (String) list.get(0);
//		int num = (Integer) list.get(1);
//		Friend f = (Friend) list.get(2);
//		System.out.println(obj);
//		System.out.println(num);
//		System.out.println(f.getName() );
		
		////// --> 변수 타입 캐스팅 해줘야하는 불편함
		
		// list <타입> 넣어주자  예시.
		List<String> list = new ArrayList<String>();

		list.add("홍길동");
		list.add("김길동");
		list.add("빅길동");
		for(int i= 0; i <= 5 ; i++) {
			list.add(String.valueOf(i));
		}
		String obj = (String) list.get(0);
		
		list.set(0, "Hong"); //list[0] = "Hong"
		System.out.println("크기: "+list.size());
		list.remove(0);
		System.out.println("크기: "+list.size());
		obj = list.get(0);
		System.out.println(obj);
		
//		list.clear(); 
//		System.out.println("크기: "+list.size());
		
		for(int i=0; i< list.size() ; i++) {
			System.out.printf("%d의 위치값 : %s \n", i, list.get(i));
		}
		
	}

}
