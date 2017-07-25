package p1.collections.demo;
/*
 * 2017年7月25日 10:19:27
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo1 {

	public static void main(String[] args) {
		
		/*
		 * Collections ：是集合工具类
		 * 里面的方法都是静态的。
		 */
		demo_1();
	}

	public static void demo_1(){
		
		List<String> list = new ArrayList<String>();
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		list.add("zzz");
		list.add("nbaa");
		System.out.println(list);
		
		//对list集合进行指定顺序的排序
//		Collections.sort(list);	//String排序
//		mySort(list);
//		Collections.sort(list, new ComparatorByLength());	//长度排序
		mySort2(list, new ComparatorByLength() );
		System.out.println(list);
	}
	
	
//比较长度
	public static <T> void mySort2(List<T> list, Comparator<? super T> com){
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				if( com.compare(list.get(i), list.get(j))>0 ){
					Collections.swap(list, i, j);
				}
			}
		}
	}
	
//按字母排序，不带比较器的源码	
	public static <T extends Comparable<? super T>> void mySort(List<T> list){
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				if( list.get(i).compareTo(list.get(j)) >0 ){
//					T temp = list.get(i);
//					list.set(i, list.get(j));
//					list.set(j,	temp);
					Collections.swap(list, i, j);
				}
			}
		}
	}
}
