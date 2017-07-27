package otherapi.demo;

import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		
		int year = 2015;
		showDay(year);
	}

	public static void showDay(int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);	//	日期的偏移
		showDate(c);
	}

	public static void showDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		String week = getWeek(c.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(year+"年"+month+"月"+day+"日  "+week);
	}

	public static String getWeek(int i) {
		String[] week = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		
		return week[i];
	}
	
}
