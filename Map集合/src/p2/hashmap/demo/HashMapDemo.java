package p2.hashmap.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import p.bean.Student;

/*2017年7月24日 11:20:03
 */
public class HashMapDemo {
	
	public static void main(String[] args) {
		
		/*
		 * 将学生对象和学生的归属地通过键与值存储到map集合中
		 */
		HashMap<Student, String> hm = new HashMap<Student, String>();
		hm.put(new Student("lisi", 38), "北京");
		hm.put(new Student("zhaoliu", 24), "上海");
		hm.put(new Student("xiaoqiang", 31), "沈阳");
		hm.put(new Student("wangcai", 28), "大连	");
		hm.put(new Student("zhaoliu", 24), "铁岭");
		
		
//方法一 : keySet()方法：
//		Set<Student> keySet = hm.keySet();
//		Iterator<Student> it = keySet.iterator();
		Iterator<Student> it = hm.keySet().iterator();
		
		while(it.hasNext()){
			Student key = it.next();
			String value = hm.get(key);
			System.out.println(key.getName()+":"+key.getAge()+"---"+value);
		}
		
//方法二：entrySet()方法:		
		Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
		Iterator<Map.Entry<Student, String>> it1 = entrySet.iterator();
		while(it1.hasNext()){
			Map.Entry<Student, String> me = it1.next();
			Student key = me.getKey();
			String value = me.getValue();
			System.out.println(key.getName()+":"+key.getAge()+"---"+value);
		}
	}
}
	

