package p5.map.test;

import java.util.HashMap;

/*
 * 2017年7月24日 20:29:39
 */
public class MapTest3 {
	public static void main(String[] args) {
		
		getWeek(10);
		
	}
	
	public static void getWeek(int week){
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "星期一");
		hm.put(2, "星期二");
		hm.put(3, "星期三");
		hm.put(4, "星期四");
		hm.put(5, "星期五");
		hm.put(6, "星期六");
		hm.put(7, "星期七");
		if(week<1 || week>7)
			throw new RuntimeException("没有对应的星期！");
		
		String value = hm.get(week);
		System.out.println(value);
	}
}
