package string.demo;

/*	2017年7月19日19:03:45
 * 
 * 	String中的方法：
 */
public class StirngMethodDemo {
	public static void main(String[] args) {
		
		/*
		 * 按照面向对象的思想对字符串进行功能的分类
		 * "abcd"
		 * 
		 * 1,获取：
		 * 		1.1：获取字符串中字符的个数(长度): 	
		 * 			int length();
		 * 		1.2: 根据位置获取字符：				
		 * 			char charAT(int index);
		 * 		1.3: 根据字符获取在字符串中第一次出现的位置		
		 * 			int indexOf(int ch);
		 * 			int indexOf(int ch, int fromIndex);	从指定的索引开始。
		 * 			int indexOf(String str);
		 * 			int indexOf(String str, int fromIndex);
		 * 			根据字符串获取在字符串中第一次出现的位置
		 * 			int lastIndexOf(int ch);
		 * 			int lastIndexOf(int ch, int fromIndex);	从指定的索引开始。
		 * 			int lastIndexOf(String str);
		 * 			int lastIndexOf(String str, int fromIndex);
		 * 		1.4: 获取字符串中的一部分字符串。也叫子串
		 * 			String substring(int beginIndex, int endIndex);	//包含begin不包含end
		 * 			String substring(int beginIndex);
		 */
		stringMethodDemo_1();
	}

	private static void stringMethodDemo_1() {
		String s = "abcahjde";
		System.out.println("length: "+s.length());	//length: 8
		System.out.println("char: "+s.charAt(2));	//char: c
		System.out.println("index: "+s.indexOf('a'));//index: 0
		System.out.println("lastIndex: "+s.lastIndexOf('a'));//lastIndex: 3
		System.out.println("index of 'bc': "+s.indexOf("bc"));	//index of 'bc': 1
		System.out.println("substring: "+s.substring(2));	//substring: cahjde
		System.out.println("substring: "+s.substring(2, 4));//substring: ca
	}
}
