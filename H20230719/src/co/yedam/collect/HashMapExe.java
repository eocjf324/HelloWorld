package co.yedam.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExe {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("박길동", 88);
		map.put("홍길동", 90);
		
		map.remove("홍길동");
		
		if(map.containsKey("박길동")) {
			Integer result = map.get("박길동");
			System.out.println("박길동의 점수: " + result);
		}
		
		//반복된 요소 출력.
		Set<String> keys = map.keySet(); //키 값만 set 컬렉션에 저장.
		for(String key : keys) {
			Integer val = map.get(key);
			System.out.printf("key: %s, val: %d\n", key,val);
		}
		
		Set<Entry<String,Integer>> entrySet = map.entrySet(); // K, V => {K,V}
		for(Entry<String,Integer> entry : entrySet) {
			String key = entry.getKey();
			int val = entry.getValue();
			System.out.printf("key: %s, val: %d\n", key,val);
		}
		
		System.out.println("종료");
		
	}
}
