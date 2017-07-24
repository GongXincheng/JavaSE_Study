package p5.map.test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 * 2017年7月24日 18:24:46
 * 
 * 练习：
 * 			“fdgavcbsacdfs” 获取该字符串中，每一个字母出现的次数
 * 			要求打印结果为： a(2) b(1);
 * 思路：
 * 		对于结果的分析结果，字母和次数之间存在着映射关系。而且这样关系很多
 * 		很多就需要存储，能存储映射关系的容器有数组和Map
 * 		关系一方是有序编号吗？没有！
 * 		那就是用Map集合，又发现可以保证唯一性的一方具备着顺序 a b c ...
 * 		所以可以使用TreeMap集合
 * 
 * 1.因为操作的字符串中的字母，所以先将字符串变成字符数组。
 * 2.遍历字符数组，用每一个字母作为键去查Map集合这个表
 * 3. 如果该字母键不在，就将该字母作为键1作为值存到map集合中
 * 	    如果该字母键存在，就将该字母键对应的值取出+1后的值存储到map集合中
 * 	    键相同值会覆盖，这样就记录了该字母的次数
 * 4.遍历结束，map就记录了所有字母出现的次数。
 * 
 * 
 */
public class MapTest2 {
	public static void main(String[] args) {
		
		String str = "fdga  vcb---sacdfs";
		
		String s = getCharCount(str);
		System.out.println(s);
	}

	private static String getCharCount(String str) {
		
		//将字符串变成字符数组
		char[] chs = str.toCharArray();
		 
		//定义map集合表
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		for (int i = 0; i < chs.length; i++) {
			
			//判断是否为字符
			if(!(chs[i]>='a' && chs[i]<='z' || chs[i]>='A' && chs[i]<='Z'))
				continue;
			
			//将数组中的字母作为键去查map表
			Integer value = map.get(chs[i]);
//优化	
			int count = 1;
			//判断值是否为空
			if(value != null)
				count = value + 1;
				
			map.put(chs[i], count);
			
//			if(value==null)
//				map.put(chs[i], 1);
//			else
//				map.put(chs[i], value+1);
			
		}
		
		return mapToString(map);
	}

	private static String mapToString(Map<Character, Integer> map) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Iterator<Character> it = map.keySet().iterator();
		while(it.hasNext()){
			Character key = it.next();
			Integer value = map.get(key);
			sb.append(key+"("+value+")");
		}
		
		return sb.toString();
	}
	
	//a(2)b(1)c(2)d(2)f(2)g(1)s(2)v(1)
}
