package p7.treeset.demo;

import java.util.Iterator;
import java.util.TreeSet;

import p.bean.Person;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		demo1();
		
		/*
		 * 以Person对象的年龄进行从小到大的排序
		 * 	重写了 Person 的 compareTo() 方法；
		 */
		TreeSet ts = new TreeSet(/*new ComparatorByName()*/);
		
		ts.add(new Person("lisi", 21));
		ts.add(new Person("wangwu", 29));
		ts.add(new Person("zhangsan", 28));
		ts.add(new Person("zhangsan", 29));
		ts.add(new Person("zhangsan", 21));
		ts.add(new Person("zhaoliu", 25));
		
		Iterator it = ts.iterator();
		while(it.hasNext()){
			Person p = (Person) it.next();
			
			System.out.println(p.getName()+": "+p.getAge());
		}
		
/*	输出结果：
 * ----------------------------
	lisi: 21
	zhangsan: 21
	zhaoliu: 25
	zhangsan: 28
	wangwu: 29
	zhangsan: 29
 ------------------------------- */
	}
//-----------------------------------------------------------
	private static void demo1() {
		TreeSet ts = new TreeSet();
		
		ts.add("abc");
		ts.add("aa");
		ts.add("nba");
		ts.add("cba");
		
		Iterator it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
