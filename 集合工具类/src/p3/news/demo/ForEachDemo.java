package p3.news.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 2017年7月25日 21:41:26
 * 
 * Foreach语句：
 * 格式：
 * 	for(类型 变量 ：Collection集合(或数组))
 * 	{}
 * 
 * 传统for 和 foreach 的区别
 * 传统for可以完成对语句执行很多次。因为可以定义控制循环的增量条件
 * 
 * 高级for 是一种简化形式，它必须有被遍历的目标，该目标要么是数组，要么是单列集合
 * 
 * 对于数组的遍历，如果仅仅是获取数组中的元素，-> 高级for
 * 如果对数组的角标进行操作 -> 传统for
 * 
 */
public class ForEachDemo {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		
		for(String str : list){		
			System.out.println(str);
		}
		
//		Iterator<String> it = list.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		int[] arr = {3, 1, 5, 7, 4};
		for(int i : arr){
			System.out.print(i+" ");
		}
		System.out.println();
		
		//可以使用高级for遍历map集合吗？不能直接用。但是可以将map转成单列的set就可以了
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(3, "zhangsan");
		map.put(2, "hhana");
		map.put(6, "xjxjx");
		map.put(5, "asdvdsan");
		
//-使用Map对象的keySet()方法返回 set<K>--------------------------------------------------------------------
		Set<Integer> keyset = map.keySet();
		Iterator<Integer> it = keyset.iterator();
		while(it.hasNext()){
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+": "+value);
		}
//-使用Map对象的entrySet()方法返回 set<Map.Entry<K,V>>--------------------------------------------------------------------		
		Iterator<Map.Entry<Integer, String>> it1 = map.entrySet().iterator();
		while(it1.hasNext()){
			Map.Entry<Integer, String> me = it1.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+": "+value);
		}
		
//-使用foreach遍历--------------------------------------------------------------------		
		for(Integer key : map.keySet()){
			String value = map.get(key);
			System.out.println(key+": "+value);
		}
		
		for(Map.Entry<Integer, String> me : map.entrySet() ){
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}
	}
}
