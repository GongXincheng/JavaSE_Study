package p1.collection.demo;
/*
 * 2017年7月21日12:42:58
 * 
 *	迭代器
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class IteratorDemo {

	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		
		//使用Collection中的Iterator()方法.调用集合中的迭代器方法，是为了获取集合中的迭代器对象
		Iterator it = coll.iterator();
		while( it.hasNext() ){
			System.out.println(it.next());
		}
		
		
//		开发中的书写：
		for(Iterator it1 = coll.iterator(); it1.hasNext(); ){
			System.out.println(it1.next());
		}
	}
}
