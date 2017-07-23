package p6.hashset.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/*
 * 2017年7月22日 14:04:12
 */
public class LinkedHashSetDemo {
	public static void main(String[] args) {
		
		HashSet hs = new LinkedHashSet();
		
		hs.add("hahah");
		hs.add("xixix");
		hs.add("heihei");
		hs.add("hehehe");
		 
		Iterator it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
