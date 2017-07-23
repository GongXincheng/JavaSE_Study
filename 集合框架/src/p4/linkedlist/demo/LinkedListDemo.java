package p4.linkedlist.demo;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
	
	public static void main(String[] args) {
		
		LinkedList link = new LinkedList();
		
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		link.addFirst("abc4");
		System.out.println(link);	//[abc4, abc3, abc2, abc1]
//		System.out.println(link.getFirst());	//abc4		//获取第一个元素，但不删除
//		System.out.println(link.getFirst());	//abc4
		
//		System.out.println(link.removeFirst());		// abc4		//获取第一个元素，但是会删除
//		System.out.println(link.removeFirst());		// abc3
//		System.out.println(link);					// [abc2, abc1]
		
		while(!link.isEmpty()){
			System.out.println(link.removeFirst());	//link.removeLast()
		}
		System.out.println(link);	//4 3 2 1 
		
//		Iterator it = link.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
	}
}
