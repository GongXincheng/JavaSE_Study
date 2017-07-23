package p1.generic.demo;
/*
 * 	2017年7月23日 11:49:54
 */
import java.util.Iterator;
import java.util.TreeSet;
import p.bean.Person;

public class GenericDemo2 {
	
	public static void main(String[] args) {
		
		TreeSet<Person> ts = new TreeSet<Person>(new ComparatorByName());
		
		ts.add(new Person("lisi8", 21));
		ts.add(new Person("lisi3", 23));
		ts.add(new Person("lisi", 21));
		ts.add(new Person("lis0", 20));
		
		Iterator<Person> it = ts.iterator();
		while(it.hasNext()){
			Person p = it.next();
			System.out.println(p.getName()+":"+p.getAge());
		}
	}
}
