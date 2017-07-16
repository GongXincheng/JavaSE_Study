package Object;

class Person extends Object{
	private int age;
	Person(int age){
		this.age = age;
	}
	
	public boolean equals(Object obj){	// Object obj = p1;  person向上转型  隐藏子类的特有功能
		if( !( obj instanceof Person) ){	//如果传过来的类型和Person类型不同
			throw new ClassCastException("类型错误");	//抛出（运行时）异常
		}
		Person p = (Person)obj;
		return this.age == p.age;
	}
}
class Demo{
	//用于测试的类
} 
public class Object_Demo {
	public static void main(String[] args) {
		Person p1 = new Person(20);
		Person p2 = new Person(20);
		System.out.println(p1.equals(p2));	//true
		
		Class clazz1 = p1.getClass();
		Class clazz2 = p2.getClass();			// getClass()  方法
		System.out.println(clazz1 == clazz2);	//true
		System.out.println(clazz1.getName());	
		
		System.out.println(p1);
		System.out.println(p1.getClass().getName()+"$"+ Integer.toHexString( p1.hashCode() ) );	
		//							 类名						哈希码(16进制)
		
		Demo d = new Demo();				
		System.out.println(p1.equals(d));	// Exception in thread "main" java.lang.ClassCastException: 类型错误
		
		/*	(未把equals方法覆盖前)
		System.out.println(p1 == p2); 		// false
		System.out.println(p1.equals(p2));	// false  等同于  p1 == p2
		*/
	}
}
