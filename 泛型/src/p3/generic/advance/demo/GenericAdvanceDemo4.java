package p3.generic.advance.demo;
/*
 * 2017年7月23日 17:16:59
 */
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import p.bean.Person;
import p.bean.Student;
import p.bean.Worker;

public class GenericAdvanceDemo4 {
	public static void main(String[] args) {
		
		TreeSet<Person> al1 = new TreeSet<Person>(new CompByName());	//Person
		al1.add(new Person("abc4", 34));
		al1.add(new Person("abc1", 30));
		al1.add(new Person("abc2", 38));
		
		TreeSet<Student> al2 = new TreeSet<Student>(new CompByName());	//Student
		al2.add(new Student("stu1", 11));
		al2.add(new Student("stu7", 20));
		al2.add(new Student("stu2", 22));
		
		TreeSet<Worker> al3 = new TreeSet<Worker>();	//Worker
		al3.add(new Worker("Worker1", 11));
		al3.add(new Worker("Worker2", 22));
		
		
		TreeSet<String> al4 = new TreeSet<String>();
		al4.add("abcdefg");
		
		al1.addAll(al2);
				
		Iterator<Person> it = al1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	
	}
}
/*	class TreeSet<E>
 * {
 * 		TreeSet(Comparator<? super E> comp);
 * }
 * 
 * 	什么时候用下限，通常对集合中的元素进行取出操作时，可以用下限
 */
class CompByName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		int temp = o1.getName().compareTo(o2.getName());
		return temp==0 ? o1.getAge()-o2.getAge() : temp;
	}
}

class CompByStuName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		int temp = o1.getName().compareTo(o2.getName());
		return temp==0 ? o1.getAge()-o2.getAge() : temp;
	}
}



