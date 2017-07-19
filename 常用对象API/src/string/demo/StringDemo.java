package string.demo;

public class StringDemo {
	public static void main(String[] args) {
		
		/*
		 * 	String 的特点：
		 * 		字符串对象一旦被初始化就不会被改变
		 */
		StringDemo2();
	}

	private static void StringDemo2() {
		// TODO Auto-generated method stub
		
		String s = "abc";	//创建一个字符串对象在常量池中  并把地址赋给s引用型变量
		String s1 = new String("abc");	//创建两个对象，一个new，一个字符串对象在堆内存中 被new对象维护
		
		System.out.println("s = " +s);
		System.out.println("s1 = " +s1);
		System.out.println(s1==s);	//false
		System.out.println(s.equals(s1)); //true  String类中复写了Object中的equals，比较字符串内容
	}

	/**
	 * 演示字符串定义的第一种方式，并明确字符串常量池的特点
	 * 池中没有就建立，池中有，就直接用
	 */
	private static void StringDemo1() {
		String s = "abc";	// “abc”储存在字符串常量池中。
		String s1 = "abc";
		System.out.println(s == s1);	//true
	}
}
