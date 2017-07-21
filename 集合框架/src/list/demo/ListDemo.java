package list.demo;

import java.util.ArrayList;
import java.util.List;

/*
 * 2017年7月21日14:19:36
 * 
 */
public class ListDemo {
	public static void main(String[] args) {
		
		List list = new ArrayList();
		show(list);
	}

	private static void show(List list) {
		
		//添加元素
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		System.out.println(list);
		
		//插入元素
		list.add(1, "abc9");
		System.out.println(list);
		
		//删除元素
		System.out.println("remove: " +list.remove(1));	//返回被删除的值
		System.out.println(list);
		
		//修改元素
		System.out.println("set: " +list.set(0, "abc100"));	//返回被修改的值
		System.out.println(list);
		
		//获取元素
		System.out.println("get: " +list.get(0));
		System.out.println(list);
		
		//获取子列表
		System.out.println("sublist: " +list.subList(1, 2));  //包含首不包含尾
		System.out.println(list);
		
		/*	运行结果：
		-----------------------
		[abc1, abc2, abc3]
		[abc1, abc9, abc2, abc3]
		remove: abc9
		[abc1, abc2, abc3]
		set: abc1
		[abc100, abc2, abc3]
		get: abc100
		[abc100, abc2, abc3]
		sublist: [abc2]
		[abc100, abc2, abc3]
		-----------------------
		*/
	}
}
