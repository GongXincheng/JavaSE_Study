package stringbuffer.test;
/*
 * 2017年7月20日15:00:44
 * 
 * 	StringBuilder 练习
 */
public class StringBuilderTest {
	public static void main(String[] args) {
		int[] arr = {2, 6, 88, 9, 7};
		
//		String s = arrayToString_1(arr);
		String s = arrayToString_2(arr);
		
		System.out.println(s);	//[2, 6, 88, 9, 7]
	}
	
	/**
	 *  将一个int数组变成字符串,StringBuilder方法
	 * @param arr
	 * @return
	 */
	private static String arrayToString_2(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			if(i!=arr.length-1)
				sb.append(arr[i]+", ");
			else
				sb.append(arr[i]+"]");
		}
		
		return sb.toString();
	}

	
	
	/**
	 * 将一个int数组变成字符串,字符串连接的方法
	 */
	
	public static String arrayToString_1(int[] arr){
		
		String str = "[";
		for (int i = 0; i < arr.length; i++) {
			if(i!=arr.length-1)
				str += arr[i] + ", ";
			else
				str += arr[i] + "]";
		}
		
		return str;
	}
}
