package vector.demo;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/*
 * 2017年7月21日16:24:05
 */

public class VectorDemo {
	public static void main(String[] args) {
		Vector v = new Vector();
		
		v.addElement("abc1");
		v.addElement("abc2");
		v.addElement("abc3");
		v.addElement("abc4");
		
		//特有的遍历方法
		Enumeration en = v.elements();
		while(en.hasMoreElements()){
			System.out.println("nextElement: " + en.nextElement());
		}
		
		Iterator it = v.iterator();
		while(it.hasNext()){
			System.out.println("next: "+it.next());
		}
		
	}
}
