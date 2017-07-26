package otherapi.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 2017年7月26日 16:04:19
 * 
 * 	"2012-3-17" 到 "2012-4-6" 
 *	 中间有多少天
 */
public class DateTest {

	public static void main(String[] args) throws ParseException {
		
		String date_str1 = "2012-3-17";
		String date_str2 = "2012-4-6";
		
		test(date_str1,date_str2);
		
	}

	public static void test(String date_str1, String date_str2) throws ParseException {
			//日期字符串->日期对象
			//定义日期格式对象
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = dateFormat.parse(date_str1);
			Date date2 = dateFormat.parse(date_str2);
		
			//将日期对象-> 毫秒值
			long time1 = date1.getTime();
			long time2 = date2.getTime();
			
			long time = Math.abs(time1-time2);
			
			int day = getDay(time);
			System.out.println(day);
	}

	public static int getDay(long time) {
		
		int day = (int)time/1000/60/60/24;
		
		return day;
	}
	
}
