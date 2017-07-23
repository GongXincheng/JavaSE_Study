package p2.list.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * 2017年7月21日14:38:45
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List list = new ArrayList();
//		show(list);
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		System.out.println(list);
		
		ListIterator it = list.listIterator();//获取列表迭代器对象
												//它可以实现在迭代过程中完成对元素的增删改查
												//注意：只有List集合中具备该迭代功能
		while(it.hasNext()){
			Object obj = it.next();
			if(obj.equals("abc2")){
				it.add("abc9");	//it.set("abc9");
			}
		}
		System.out.println(list);		// [abc1, abc2, abc9, abc3]
		
//		System.out.println("hasNext: " + it.hasNext());		//hasNext: false
//		System.out.println("hasPrevious: " + it.hasPrevious());		//hasPrevious: true
		
		while(it.hasPrevious()){
			System.out.println("previous: " + it.previous());	//逆序输出 
		}
		System.out.println(list);
		
//--------------------------------------------------------------------------------------------------		
//		Iterator it = list.iterator();
//		while(it.hasNext()){
//			
//			Object obj = it.next();//抛出异常：java.util.ConcurrentModificationException
//							//在迭代器过程中，不要使用集合操作元素，容易出现异常。
//						//可以使用Iterator接口的子接口ListIterator来完成在迭代中对元素进行更多的操作。 
//			
//			if(obj.equals("abc2")){
//				list.add("abc9");
//			}
//			else
//				System.out.println("next:"+obj);
//		}
//		System.out.println(list);
	
	}

	private static void show(List list) {
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println("next: "+ it.next());
		}

		//list特有的取出元素的方式之一，只有list有
		for(int i = 0; i<list.size(); i++){
			System.out.println("get: " + list.get(i));
		}
		
		for(Object obj:list){
			System.out.println(obj);
		}
	}
}
