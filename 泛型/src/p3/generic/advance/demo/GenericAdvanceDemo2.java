package p3.generic.advance.demo;
/*
 * 2017年7月23日 16:13:11
 * 通配符 ？
 * 泛型限定的第一种体现， <? extends Person>
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p.bean.Person;
import p.bean.Student;
import p.bean.Worker;

public class GenericAdvanceDemo2 {
	public static void main(String[] args) {
		
		ArrayList<Worker> al = new ArrayList<Worker>();
		al.add(new Worker("abc", 30));
		al.add(new Worker("abc4", 34));
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		al2.add(new Student("stu1", 11));
		al2.add(new Student("stu2", 22));
		
		ArrayList<String> al3 = new ArrayList<String>();
		al3.add("stu33333331");
		al3.add("stu22222222");
		
		printCollection(al);
		printCollection(al2);
//		printCollection(al3);	//编译会出错，泛型的限定
	}
	
	/**
	 * 迭代并打印集合中的元素
	 * 如果不对元素进行操作，只是打印，就是用该方法
	 * 使用通配符 : ?
	 * 
	 * 可以对类型进行限定
	 * 	? extends E : 接收E类型或者E的子类型对象。 上限！
	 * 	? super E : 接收E类型或者E的父类型对象。 下限！
	 * 
	 * @param al
	 */
	private static void printCollection(Collection<? extends Person> al) {	
											//Collection<? extends Person> al = new ArrayList<Worker>;
		Iterator<? extends Person> it = al.iterator();
		while(it.hasNext()){
//			System.out.println(it.next().toString());
			Person p = it.next();								//666
			System.out.println(p.getName()+":"+p.getAge());
		}
	}

/*如果对元素进行操作，就是用该方法
	private static <T> void printCollection(Collection<T> al) {
		Iterator<T> it = al.iterator();
		while(it.hasNext()){
			T t = it.next();
			System.out.println(t);
		}
	}
*/
	
	
/*
		abc:30
		abc4:34
		stu1:11
		stu2:22
*/	
}
