package p2.arrays.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 2017年7月25日 20:59:59
 */
public class ToArray {
	public static void main(String[] args) {
		/*
		 * 集合转数组
		 * 
		 * 使用的就是 Collection接口中的 toArray() 方法
		 * 集合转成数组，可以对集合中的元素操作进行限定。不允许对其进行增删。
		 * 
		 */
		
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		/*
		 * toArray方法需要传入一个指定类型的数组
		 * 如果长度小于集合的size，那么该方法会创建一个同类型并和集合相同size的数组
		 * 如果长度大于集合的size，那么该方法就会使用指定的数组，存储集合中的元素，其他位置默认为null
		 * 所以建议长度指定为 集合的size()
		 */
		String[] arr = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(arr));
	}
}
