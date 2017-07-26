package otherapi.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 2017年7月26日 15:15:20
 * 对日期对象进行格式化
 */

public class DateDemo2 {

	public static void main(String[] args) {
//			methodDemo_1();
			methodDemo_2();
	}
	
	/**
	 * 
	 * 		日期对象 -> 日期格式的字符串:
	 * 			使用的是 DateFormat 的 format()方法  返回字符串对象
	 */
	public static void methodDemo_1() {
		
		Date date = new Date();	//获取当前时间对象
		
		//获取日期格式对象	 LONG:2017年7月26日 	 FULL:2017年7月26日 星期三
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);	//日期对象，只有日期没有时间
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		System.out.println(dateFormat);	//java.text.SimpleDateFormat @a0ba3d93
		
		//如果风格是自定义的如何解决呢？
		SimpleDateFormat dateFormat1 =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = dateFormat1.format(date);
		System.out.println(time);
	}
	
	
	/**
	 * 	日期格式的字符串 -> 日期对象
	 *			使用的是 DateFormat 的 parse() 方法返回日期对象
	 */
	public static void methodDemo_2() {
		String date_str = "2012-4-19";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			Date date = dateFormat.parse(date_str);
			System.out.println(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
