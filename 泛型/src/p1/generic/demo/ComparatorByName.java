package p1.generic.demo;

import java.util.Comparator;
import p.bean.Person;

public class ComparatorByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0 ? o1.getAge()-o2.getAge() : temp;
	}
	
}
