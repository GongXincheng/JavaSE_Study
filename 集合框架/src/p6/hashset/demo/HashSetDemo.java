package p6.hashset.demo;

import java.util.HashSet;
import java.util.Iterator;

/*
 * 2017年7月22日 14:04:12
 */
public class HashSetDemo {
	public static void main(String[] args) {
		
		HashSet hs = new HashSet();
		
		hs.add("hahah");
		hs.add("xixix");
		hs.add("heiheih");
		hs.add("heheeh");
		hs.add("heheeh");
		 
		Iterator it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
