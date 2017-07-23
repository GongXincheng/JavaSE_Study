package p3.generic.advance.demo;
/*
 *	2017年7月23日 17:55:31
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p.bean.Person;

public class GenericAdvanceDemo5 {
	public static void main(String[] args) {
		
		ArrayList<Person> al1 = new ArrayList<Person>();	//Person
		al1.add(new Person("abc", 30));
		al1.add(new Person("abc4", 34));
		
		ArrayList<Person> al2 = new ArrayList<Person>();	//Person
		al2.add(new Person("abc222222222", 30));
		al2.add(new Person("abc422222222", 34));
		
		ArrayList<String> al4 = new ArrayList<String>();
		al4.add("abcdefg");
		al4.add("abc");
	
		al1.containsAll(al2);
	}
	
	public static void printCollection(Collection<?> al) {	
		Iterator<?> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
			
		}
	}
	
}

class MyCollection2<E>{
	public boolean containsAll(Collection<?> coll){
		
		return true;
	}
}




