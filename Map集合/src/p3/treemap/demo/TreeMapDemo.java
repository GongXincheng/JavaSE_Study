package p3.treemap.demo;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import p.bean.Student;

public class TreeMapDemo {
	
	public static void main(String[] args) {
		
		TreeMap<Student, String> tm = new TreeMap<Student, String>(new ComparatorByName());
																		//此时按姓名排序
		tm.put(new Student("lisi", 38), "北京");
		tm.put(new Student("zhaoliu", 24), "上海");
		tm.put(new Student("xiaoqiang", 31), "沈阳");
		tm.put(new Student("wangcai", 28), "大连	");
		tm.put(new Student("zhaoliu", 24), "铁岭");

//entrySet();	此时按年龄排序
		Iterator<Map.Entry<Student, String>> it = tm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Student, String> me = it.next();
			Student key = me.getKey();
			String value = me.getValue();
			System.out.println(key.getName()+":"+key.getAge()+"---"+value);
		}
		
	}
	
}

/*
		lisi:38---北京
		wangcai:28---大连	
		xiaoqiang:31---沈阳
		zhaoliu:24---铁岭
*/
