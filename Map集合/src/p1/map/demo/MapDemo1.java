package p1.map.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
	
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(8, "wangwu");
		map.put(2, "zhaoliu");
		map.put(7, "xiaoqiang");
		map.put(6, "wangcai");
		
//		method1(map);
//		method2(map);
		method3(map);
		getMapValues(map);
	}
	
	
//获取map集合中的所有 值;
	private static void getMapValues(Map<Integer, String> map) {
			// TODO Auto-generated method stub
		Collection<String> coll = map.values();
		Iterator<String> it = coll.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println(value);
		}
	}



	//取出map中的所有元素
	private static void method3(Map<Integer, String> map) {
		// TODO Auto-generated method stub
		
		/*
		 * 取出map中的所有元素
		 * 通过Map转成Set就可以迭代
		 * 找到另一个方法：entrySet();
		 *		 该方法将键和值的映射关系作为对象存储到了Set集合中，
		 * 		而这个映射关系的类型就是Map.Entry类型(结婚证)
		 */
		
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, String> me = it.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+" : "+value);
		}
		
	}

	
	
//重点方法：keySet();取出map中的所有元素
	public static void method2(Map<Integer,String> map){
		
/*		取出map中的所有元素
		 原理：通过Keyset方法获取map中所有键所在的Set集合
				在通过Set的迭代器获取每一个键,再对每一个键通过map集合的get方法获取对应的值即可
*/
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
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
