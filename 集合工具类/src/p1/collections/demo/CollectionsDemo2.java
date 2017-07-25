package p1.collections.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * 2017年7月25日 10:20:17
 */

public class CollectionsDemo2 {

	public static void main(String[] args) {
		demo_1();
	}

	public static void demo_1(){
		
		List<String> list = new ArrayList<String>();
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		list.add("zzz");
		list.add("nbaa");
		Collections.sort(list);
		System.out.println(list);
		
		int index = Collections.binarySearch(list, "cba");	//二分查找
		System.out.println(index);
		
		String max = Collections.max(list, new ComparatorByLength());	//获取最大值
		System.out.println(max);
	}
	
}
