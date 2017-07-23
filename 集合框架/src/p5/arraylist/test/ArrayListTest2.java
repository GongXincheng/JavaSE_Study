package p5.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import p.bean.Person;

/*
 * 2017年7月22日 15:24:15
 * 
 * 集合框架练习：
 * 		定义功能去除ArrayList中的重复元素
 */
public class ArrayListTest2 {
	public static void main(String[] args) {

//		singleDemo();
		
//②：自定义类的情况：
		ArrayList al = new ArrayList();
		
		al.add(new Person("lisi1", 21));
		al.add(new Person("lisi2", 22));
		al.add(new Person("lisi3", 23));
		al.add(new Person("lisi4", 24));
		al.add(new Person("lisi3", 23));
		al.add(new Person("lisi4", 24));
		System.out.println(al);
		
		al = getStringElement(al);
		System.out.println(al);

	}


	
	
//①：元素都是String的情况下：	
	private static void singleDemo() {
		ArrayList al = new ArrayList();
		al.add("abc1");
		al.add("abc2");
		al.add("abc2");
		al.add("abc1");
		al.add("abc");
		System.out.println(al);
		
		al = getStringElement(al);
		System.out.println(al);
//		Iterator it = al.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
/*输出结果：
--------------------------------------------
			[abc1, abc2, abc2, abc1, abc]
			[abc1, abc2, abc]
--------------------------------------------
*/
	}

	public static ArrayList getStringElement(ArrayList al) {
		// TODO Auto-generated method stub
		
		//1.定义一个临时容器
		ArrayList temp = new ArrayList();
		//2.迭代 al 集合
		Iterator it = al.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			//3.判断被迭代到的元素 是否在临时容器中存在
			if(! (temp.contains(obj)) ){	//如果不存在，注意contains实际是调用equals，
											//此时已经重写了Person的equals方法
				temp.add(obj);
			}
		}
		return temp;
	}
}
