package p1.collections.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
/*
 * 2017年7月25日 10:20:17
 */

public class CollectionsDemo3 {

	public static void main(String[] args) {
		demo_1();
		demo_2();
	}

	public static void demo_1(){
		
/*原理
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int temp = o2.compareTo(o1);
				return temp;
			}
		});
*/		
//		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new ComparatorByLength()));
		ts.add("abc");
		ts.add("hahaha");
		ts.add("zzz");
		ts.add("aa");
		ts.add("cba");
		
		System.out.println(ts);
	}
	
	
	
	public static void demo_2(){
		List<String> list = new ArrayList<String>();
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		list.add("zzz");
		list.add("nbaa");
		System.out.println(list);
		
		Collections.reverse(list);	//直接反转 List
		System.out.println(list);
		
		Collections.sort(list,Collections.reverseOrder());//先排序，再逆转
		System.out.println(list);
		
/*
		[abcde, cba, aa, zzz, nbaa]
		[nbaa, zzz, aa, cba, abcde]
		[zzz, nbaa, cba, abcde, aa]
 */
	}
}
