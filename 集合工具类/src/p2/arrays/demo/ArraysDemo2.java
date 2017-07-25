package p2.arrays.demo;

import java.util.Arrays;
import java.util.List;

/*
 * 2017年7月25日 17:29:52
 *
 *	重点：List asList(数组) -> 将数组转成集合
 *	好处： 可以使用集合的方法处理数组中的元素
 *	注意：数组的长度是固定的，所以对于集合的增删方法是不可以使用的
 *		否则： java.lang.UnsupportedOperationException （不能改变长度）
 */
public class ArraysDemo2 {

	public static void main(String[] args) {
		
//		demo_1();
		demo_2();
	}

	public static void demo_2() {
		/*
		 * 如果数组中的元素是对象，那么转成集合时，直接将数组中的元素作为集合中的元素进行集合存储
		 * 如果数组中的元素是基本数据类型数值，那么会将该数组作为集合中的元素进行存储
		 */
		int[] arr = {31, 11, 51, 61};
		
		List<int[]> list = Arrays.asList(arr);
		System.out.println(list);
	}

	public static void demo_1() {
		String[] arr = {"abc", "haha", "xixi"};
		boolean b = myContains(arr , "xixi");	//自己写的方法
		System.out.println("contains: " + b);
		
		List<String> list = Arrays.asList(arr);//数组转化为集合处理
		boolean b1 = list.contains("xixi");
		System.out.println("list contains: " + b1);
		
//		list.add("hiahia");	 //java.lang.UnsupportedOperationException
		System.out.println(list);
		
	}

	public static boolean myContains(String[] arr, String key) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(key))
				return true;
		}
		return false;
	}
	
}
