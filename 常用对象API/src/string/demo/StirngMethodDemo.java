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
		 * 
		 * 2,转换
		 * 		2.1： 将字符串变成字符串数组(字符串的切割)
		 * 			String[] split(String regex);	涉及到正则表达式.
		 * 		2.2： 将字符串变成字符数组
		 * 			char[] toCharArray();
		 * 		2.3: 将字符串变成字节数组
		 * 			byte[] getBytes();
		 * 		2.4： 将字符串中的字母转成大小写
		 * 			String toUpperCase();	大写
		 * 			String totoLowerCase(); 小写
		 * 		2.5：将字符串中的内容进行替换
		 * 			String replace(char oldChar, char newChar);
		 * 			String replace(String s1, String s2);
		 * 		2.6: 去除字符串两端的空格
		 * 			String trim();
		 * 		2.7: 将字符串进行连接
		 * 			String concat(String str);
		 * 
		 * 3,判断
		 * 		3.1：两个字符串内容是否相同
		 * 			boolean equals(Object obj);
		 * 			boolean equalsIgnoreCase(String str);	忽略大小写比较字符串内容
		 * 		3.2: 字符串中是否包含指定字符串
		 * 			boolean contains(String str);
		 * 		3.3: 字符串是否以指定字符串开头，否以指定字符串结尾
		 * 			boolean startsWith(String str);
		 * 			boolean endsWith(String str);
		 * 
		 * 4,比较
		 * 		
		 */
		stringMethodDemo_4();
	}

//比较
private static void stringMethodDemo_4() {
		System.out.println("a".compareTo("c"));	//b:-1   //c:-2
	}

//判断
private static void stringMethodDemo_3() {
		String s = "abc";
		System.out.println(s.equals("ABC".toLowerCase()));	//true
		System.out.println(s.equalsIgnoreCase("ABC"));		//true
//------------------------------------------------------------------------------------		
		System.out.println(s.contains("bc"));	//true
//------------------------------------------------------------------------------------
		String str = "ArrayDemo.java";
		System.out.println(str.startsWith("Array"));	//true
		System.out.println(str.endsWith(".java"));	//true
	}


//转换：
	private static void stringMethodDemo_2() {
		String s = "张三.李四.王五.宫新程";
		String[] arr = s.split("\\.");
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i]+"  ");	//张三  李四  王五  宫新程  
		}
		System.out.println();
//------------------------------------------------------------------------------------
		char[] chs = s.toCharArray();
		for(int i = 0; i<chs.length; i++){
			System.out.print("["+chs[i]+"] ");	//[张] [三] [.] [李] [四] [.] [王] [五] [.] [宫] [新] [程] 
		}
		System.out.println();
//------------------------------------------------------------------------------------		
		s = "ab宫";
		byte[] bytes = s.getBytes();
		for(int i=0; i<bytes.length; i++){
			System.out.print("["+bytes[i]+"] ");	//[97] [98] [-27] [-82] [-85]  
		}
		System.out.println();
//------------------------------------------------------------------------------------
		System.out.println("Abc".toUpperCase());	//ABC
		System.out.println("ABC".toLowerCase());	//abc
//------------------------------------------------------------------------------------
		System.out.println("java".replace('a', 'o'));	//jovo
//------------------------------------------------------------------------------------
		System.out.println("    a bc  ".trim());	//a bc
//------------------------------------------------------------------------------------		
		System.out.println("abc".concat("kk"));	//abckk
	}
	
	
//获取：
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
