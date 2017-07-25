package p2.arrays.demo;

import java.util.Arrays;

/*
 * 2017年7月25日 13:18:13
 * Arrays：集合框架的工具类，里面的方法都为静态
 * 
 *		 toString()方法
 */
public class ArraysDemo1 {

	public static void main(String[] args) {
		
		int[] arr = {23,55,2,1,-5,8};
		String str = Arrays.toString(arr);
		System.out.println(str);
		
	}
	
	 public static String myToString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {	//中间省略了条件判断，提高了效率
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
