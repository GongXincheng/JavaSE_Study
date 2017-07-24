package p1.map.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
	
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
//		method1(map);
		method2(map);
	}
	
	//重点方法：keySet();
	public static void method2(Map<Integer,String> map){
		
		map.put(8, "wangwu");
		map.put(2, "zhaoliu");
		map.put(7, "xiaoqiang");
		map.put(6, "wangcai");
		
/*		取出map中的所有元素
		 原理：通过Keyset方法获取map中所有键所在的Set集合
				在通过Set的迭代器获取每一个键,再对每一个键通过map集合的get方法获取对应的值即可
*/
		Set<Integer> keyset = map.keySet();
		Iterator<Integer> it = keyset.iterator();
		while(it.hasNext()){
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+" = "+value);
		}
	}
	
	public static void method1(Map<Integer,String> map){	//学号和姓名
		
		//添加元素：
		System.out.println(map.put(8, "wangcai"));	//null
		System.out.println(map.put(8, "xiaoqiang"));	//wangcai
		//value put(key,value):返回前一个和key关联的值，如果没有返回null.
		
		map.put(2, "zhangsan");
		map.put(7, "zhaoliu");
		
		//删除：
		System.out.println("remove: " + map.remove(2));	// remove: zhangsan
		
		//判断：
		System.out.println("containskey：" + map.containsKey(7));	// containskey：true
		
		//获取：
		System.out.println("get: " + map.get(8));	// get: xiaoqiang  没有返回null
		
		System.out.println(map);	// {8=xiaoqiang}
	}
	
}
