package p3.generic.advance.demo;
/*
 * 2017年7月23日 17:12:41
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p.bean.Person;
import p.bean.Student;
import p.bean.Worker;

public class GenericAdvanceDemo3 {
	public static void main(String[] args) {
		
		ArrayList<Person> al1 = new ArrayList<Person>();	//Person
		al1.add(new Person("abc", 30));
		al1.add(new Person("abc4", 34));
		
		ArrayList<Student> al2 = new ArrayList<Student>();	//Student
		al2.add(new Student("stu1", 11));
		al2.add(new Student("stu2", 22));
		
		ArrayList<Worker> al3 = new ArrayList<Worker>();	//Worker
		al3.add(new Worker("Worker1", 11));
		al3.add(new Worker("Worker2", 22));
		
		
		ArrayList<String> al4 = new ArrayList<String>();
		al4.add("abcdefg");
		
//		al1.addAll(al4);		//错误，类型不匹配
		al1.addAll(al2);
		
		System.out.println(al1.size());
	}
	
}
//	通常 存 元素时使用->上限
// 		因为这样取出都是按照上限类型来运算的，不会出现类型安全隐患。
class MyCollection<E>{
	public void add(){
		
	}
	public void addAll(MyCollection<? extends E> e){		//可以接收该集合的子类
		
	}
}






