package p1.generic.demo;
/*
 * 	2017年7月23日 10:29:49
 */
import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {
	
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("abc");
		al.add("hahaha");
//		al.add(123);	//编译会失败
		
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
	}
}
