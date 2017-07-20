package string.demo;

/*	2017年7月19日19:02:59
 * String的构造方法演示*/
public class StringConstructorDemo {
	public static void main(String[] args) {
		stringConstructorDemo2();
	}

	private static void stringConstructorDemo2() {
		char[] arr = {'w','a','p','q','x'};
		String s = new String(arr);
		String s1 = new String(arr, 2, 2);
		System.out.println("s = " +s);	//s = wapqx
		System.out.println("s1 = " +s1);	//s1 = pq
	}

	private static void stringConstructorDemo1() {
		String s = new String();   //等效于 String s = "";
		
		byte[] arr = {65,66,67,68,69,70};
		String s1 = new String(arr);
		System.out.println("s1 = " +s1);	//s1 = ABCDEF
	}

}
