package p1.collections.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 2017年7月25日 12:37:43
 * 
 * 1.替换：Collections.replaceAll(List<T> list, T oldVal, T newVal) 
 * 		原理：set(indexOf(oldVal), newVal)
 * 
 * 2.把所有的元素都替换为一个指定元素：
 * 		Collections.fill(List<? super T> list, T obj)
 * 
 * 3.默认随机源对指定列表进行置换(随机洗牌)
 * 		Collections.shuffle(List<?> list);
 */

public class CollectionsDemo4 {

	public static void main(String[] args) {
//		demo_1();
//		demo_2();
		demo_3();
	}
	
	public static void demo_3(){
		List<String> list = new ArrayList<String>();
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		list.add("GXC");
		list.add("zhansan");
		list.add("lisi");
		
		System.out.println(list);
		
		Collections.shuffle(list);	//随机洗牌
		System.out.println(list);	
/*
		[abcde, cba, aa, GXC, zhansan, lisi]
[lisi, abcde, cba, zhansan, aa, GXC]

 */
	}
	
	
	public static void demo_2(){
		List<String> list = new ArrayList<String>();
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		System.out.println(list);
		
		Collections.fill(list, "zzzz");	//替换所有元素
		System.out.println(list);	
/*
		[abcde, cba, aa]
		[zzzz, zzzz, zzzz]
 */
	}
	
	
	public static void demo_1(){
		List<String> list = new ArrayList<String>();
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		System.out.println(list);
		
		Collections.replaceAll(list, "cba", "nba");	//原理：set(indexOf("cba"), "nba")
		System.out.println(list);	
/*
		[abcde, cba, aa]
		[abcde, nba, aa]
 */
	}
}
