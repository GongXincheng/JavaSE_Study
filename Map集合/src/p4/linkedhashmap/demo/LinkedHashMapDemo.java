package p4.linkedhashmap.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();
		hm.put(7, "zhouqi");
		hm.put(3, "zhangsan");
		hm.put(1, "qianyi");
		hm.put(5, "wangwu");
	
// keySet()
		Iterator<Integer> it = hm.keySet().iterator(); 
		while(it.hasNext()){
			Integer key = it.next();
			String value = hm.get(key);
			System.out.println(key+": "+value);
		}
		
// entrySet()		
		Iterator< Map.Entry<Integer, String>> it1 = hm.entrySet().iterator();
		while(it1.hasNext()){
			Map.Entry<Integer, String> me = it1.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+": "+value);
		}
	}
	
}
