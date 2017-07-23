package p7.treeset.test;

import java.util.Iterator;
import java.util.TreeSet;

/*
 * 	2017年7月22日 22:19:24
 * 	对字符串的长度排序
 */
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet( new ComparatorByLength());
		ts.add("aaaaa");
		ts.add("zz");
		ts.add("nbaq");
		ts.add("cba");
		ts.add("abcbbbbbbb");
		
		Iterator it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
