package wrapper.test;

import java.util.Arrays;

/* 2017年7月21日10:31:04
 * 
 * 对一个字符串中的数值进行从小到大的排序。
 * 
 * "20 78 9 -7 88 36 29"
 * 
 * 思路：
 * 1，排序，我很熟。可是我只熟int。
 * 2，如何获取到这个字符串中的这些需要排序的数值？
 * 发现这个字符串中其实都是空格来对数值进行分隔的。
 * 所以就想到用字符串对象的切割方法将大串变成多个小串。
 * 3，数值最终变成小字符串，怎么变成一个int数呢？
 * 字符串-->基本类型 可以使用包装类。
 * 
 * 
 */

public class WrapperTest {
	private static final String SPACE_SEPARATOR = " ";
	public static void main(String[] args) {
		
		String numStr = "20 78 9 -7 88 36 29";
		System.out.println(numStr);					//20 78 9 -7 88 36 29
		
		numStr = sortStringNumber(numStr);
		System.out.println(numStr);					//-7 9 20 29 36 78 88
	}

	public static String sortStringNumber(String numStr) {
		
		//1,将字符串变成字符串数组
		String[] str_arr = stringToString(numStr);
		
		//2,将字符串数组变成int数组
		int[] num_arr = toIntArray(str_arr);
		
		//3,对int数组排序
		mySortArray(num_arr);
		
		//4,将排序后的int数组变成字符串
		String temp = arrayToString(num_arr);
		
		return temp;
	}
	
	/**
	 * 将排序后的int数组变成字符串
	 * @param num_arr
	 * @return
	 */
	public static String arrayToString(int[] num_arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num_arr.length; i++) {
			if(i!=num_arr.length-1)
				sb.append(num_arr[i]+SPACE_SEPARATOR);
			else
				sb.append(num_arr[i]);
		}
		return sb.toString();
	}

	/**
	 * 对int数组排序
	 * @param num_arr
	 */
	public static void mySortArray(int[] num_arr) {
		Arrays.sort(num_arr);
	}

	/**
	 * 将字符串数组变成int数组
	 * @param str_arr
	 * @return
	 */
	private static int[] toIntArray(String[] str_arr) {
		int arr[] = new int[str_arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		
		return arr;
	}

	/**将字符串变成字符串数组
	 * @param numStr
	 */
	private static String[] stringToString(String numStr) {
		String[] str_arr = numStr.split(SPACE_SEPARATOR);
		return str_arr;
	}
}
