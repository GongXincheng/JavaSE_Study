package p5.map.test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 * 2017年7月24日 17:01:17
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
public class MapTest {
	
	public static void main(String[] args) {
		
		String str = "fdgavcbsacdfs";
		char[] ch = str.toCharArray();
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>(new ComparatorByString());
		
		for(int i=0; i<ch.length; i++){
			if(! tm.containsKey(ch[i])){
				tm.put(ch[i], 1);
			}
			else{
				tm.put(ch[i], tm.get(ch[i])+1);
			}
		}
		
		Iterator<Map.Entry<Character, Integer>> it = tm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Character, Integer> me = it.next();
			Character key = me.getKey();
			Integer value = me.getValue();
			System.out.println(key+"("+value+")");
		}
		
	}
	
}
