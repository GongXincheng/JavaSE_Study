package collection.demo;

import java.util.ArrayList;
import java.util.Collection;

/*	2017年7月21日12:04:39
 * 
 * 
 */

public class CollectionDemo1 {
	
	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
//		show(coll);
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		show(c1, c2);
	}
	
	public static void show(Collection c1, Collection c2){
		//给c1添加元素
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		//给c2添加元素
		c2.add("abc2");
		c2.add("abc6");
		c2.add("abc7");
		System.out.println("c1 : " +c1);
		System.out.println("c2 : " +c2);
		
//---------------------------------------------------------------------------------------------	
//演示addAll
//		c1.addAll(c2);	//将c2中的元素添加到c1中
//		System.out.println("c1 : " +c1);	
		
//运行结果：		
//		c1 : [abc1, abc2, abc3, abc4]
//		c2 : [abc2, abc6, abc7]
//		c1 : [abc1, abc2, abc3, abc4, abc2, abc6, abc7]
		
						//---------------------------------------------------------------------------------------------
						//演示removeAll
						//		boolean b = c1.removeAll(c2);	//将两个集合中的相同元素从调用removeAll的集合中删除
						//		System.out.println("removeAll: " +b);
						//		System.out.println("c1: " +c1);
						
						//运行结果：
						//		c1 : [abc1, abc2, abc3, abc4]
						//		c2 : [abc2, abc6, abc7]
						//		removeAll: true
						//		c1: [abc1, abc3, abc4]
						
//---------------------------------------------------------------------------------------------
//演示containsAll
//		boolean b1 = c1.containsAll(c2);	
//		System.out.println("containsAll: " +b1);
//		System.out.println("c1: " +c1);		
		
//运行结果：		
//		c1 : [abc1, abc2, abc3, abc4]
//		c2 : [abc2, abc6, abc7]
//		containsAll: false
//		c1: [abc1, abc2, abc3, abc4]
		
						//---------------------------------------------------------------------------------------------
						//演示retainAll：取交集，保留和指定集合相同的元素，删除不同元素，和removeAll功能相反
								boolean b2 = c1.retainAll(c2);
								System.out.println("c1: " +c1);
								
						//运行结果
						//		c1 : [abc1, abc2, abc3, abc4]
						//		c2 : [abc2, abc6, abc7]
						//		c1: [abc2]
										
						//---------------------------------------------------------------------------------------------
}
	public static void show(Collection coll){
		
		//1.添加元素。 add方法
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		System.out.println(coll);	//[abc1, abc2, abc3]
		
		
		//2.删除元素 remove
		coll.remove("abc2");	//会改变集合的长度
		System.out.println(coll);	//[abc1, abc3]
		
		//判断
		System.out.println(coll.contains("abc1"));	//true
		System.out.println(coll.isEmpty());	//false
		
		//3.清空集合
		coll.clear();
		System.out.println(coll);	//[]
		
	
	}
}

