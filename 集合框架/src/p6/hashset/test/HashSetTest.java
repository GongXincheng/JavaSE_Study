package p6.hashset.test;

import java.util.HashSet;
import java.util.Iterator;

import p.bean.Person;

public class HashSetTest {
	public static void main(String[] args) {
		
		HashSet hs = new HashSet();
		/*
		 * HashSet集合数据结构是哈希表，所以存储元素的时候，
		 * 使用的元素的hashCode方法来确定位置，如果位置相同，在通过元素的equals来确定是否相同。 
		 */
		hs.add(new Person("lisi4", 27));
		hs.add(new Person("lisi7", 27));
//		hs.add(new Person("lisi1", 21));
//		hs.add(new Person("lisi9", 29));
		hs.add(new Person("lisi7", 27));

		Iterator it = hs.iterator();
		while(it.hasNext()){
			Person p = (Person)it.next();
			System.out.println(p.getName() + ": " + p.getAge());
		}
		
		
/*运行结果：
-------------------------------------
lisi4:27.....hashcode方法..
lisi7:27.....hashcode方法..
lisi7:27.....hashcode方法..
lisi7:27.....equals方法....lisi7:27
lisi4: 27
lisi7: 27
-------------------------------------*/
	}
}
