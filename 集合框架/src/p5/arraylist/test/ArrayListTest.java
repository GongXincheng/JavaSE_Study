package p5.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import p.bean.Person;

/*
 *	2017年7月22日 13:23:54
 *
 * 
 */
public class ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		
		al.add(new Person("lisi1", 21));
		al.add(new Person("lisi2", 22));
		al.add(new Person("lisi3", 23));
		al.add(new Person("lisi4", 24));
		
		Iterator it = al.iterator();
		while(it.hasNext()){
			Person p = (Person)it.next();	//注意强转！ 因为it.next()返回的是Object类型 
			System.out.println(p.getName()+ "::" + p.getAge());
		}
		
	}
}
